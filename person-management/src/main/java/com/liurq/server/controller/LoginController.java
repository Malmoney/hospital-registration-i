package com.liurq.server.controller;

import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author:hyz
 * @Date:2021-02-05
 * @Desc:登录控制器
 **/
@RestController
@RequestMapping("/server/login")
public class LoginController {


    @Autowired
    private LoginService loginService;

    /**
     * 获取验证码
     * @param userPhone
     * @return
     */
    @RequestMapping(value = "/getNumber")
    public RspInfo getNumber( String userPhone) {
        return loginService.getNumber(userPhone);
    }

    @RequestMapping("/toMain")
    public RspInfo toMain(@AuthenticationPrincipal UserDetails  user){
        return loginService.toMain(user);
    }
}
