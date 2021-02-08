package com.liurq.server.handler;

import com.liurq.server.dao.UserMapper;
import com.liurq.server.feign.PersonRedisFeignClient;
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
 * @Desc:
 **/
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;
    @Autowired
    private UserMapper userMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse rsp, Authentication a) throws IOException, ServletException {
        //获取认证用户信息
        User user = (User) a.getPrincipal();
        String userPhone = user.getUsername();

        //移除redis中的验证码
        personRedisFeignClient.removeAuthCode(userPhone);
        //向redis中存储Token

        //查询数据库
        com.liurq.server.model.User u = userMapper.selectByUserPhone(userPhone);
        if (ObjectUtils.isEmpty(u)){
            rsp.sendRedirect("/person/userInfo.html");
        }
        rsp.sendRedirect("/person/main.html");
    }
}
