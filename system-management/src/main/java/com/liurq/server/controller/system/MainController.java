package com.liurq.server.controller.system;

import com.liurq.server.dao.UserMapper;
import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author:hyz
 * @Date:2021-02-11
 * @Desc:跳往主页的controller
 **/
@Controller
public class MainController {

    @Autowired
    PersonRedisFeignClient personRedisFeignClient;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/server/login/toMain")
    @ResponseBody
    public RspInfo<String> toMain(HttpSession session){
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        User user = (User) securityContext.getAuthentication().getPrincipal();
        String userPhone = user.getUsername();
        //移除redis中的验证码
        personRedisFeignClient.removeAuthCode(userPhone);
        //向redis中存储Token
        String token = IDUtils.genUUId();
        personRedisFeignClient.setUser(user, token);
        //查询数据库
        com.liurq.server.model.User u = userMapper.selectByUserPhone(userPhone);
        if (ObjectUtils.isEmpty(u)){
            return RspInfo.success("999");
        }
        return RspInfo.success(token);
    }

}
