package com.liurq.server.handler;

import com.liurq.server.dao.UserMapper;
import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:hyz
 * @Date:2021-02-08
 * @Desc: 自定义登录Handler，已失效
 **/
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse rsp, Authentication a) throws IOException {
        //获取认证用户信息
        User user = (User) a.getPrincipal();
        String userPhone = user.getUsername();
        //移除redis中的验证码
        personRedisFeignClient.removeAuthCode(userPhone);
        //向redis中存储Token
        personRedisFeignClient.setUser(user,"123123");
        //查询数据库
        com.liurq.server.model.User u = userMapper.selectByUserPhone(userPhone);
        if (ObjectUtils.isEmpty(u)){
            rsp.sendRedirect("/system/userInfo.html");
        }
        rsp.sendRedirect("/server/login/toMain");

    }
}
