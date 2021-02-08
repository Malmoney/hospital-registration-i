package com.liurq.server.controller;

import com.liurq.server.restful.req.CommonHeadReq;
import com.liurq.server.restful.req.ReqInfo;
import com.liurq.server.restful.req.person.LoginReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public RspInfo getNumber( @Valid String userPhone) {
        return loginService.getNumber(userPhone);
    }



}
