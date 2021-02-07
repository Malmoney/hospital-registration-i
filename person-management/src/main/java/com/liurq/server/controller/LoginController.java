package com.liurq.server.controller;

import com.liurq.server.restful.req.CommonHeadReq;
import com.liurq.server.restful.req.ReqInfo;
import com.liurq.server.restful.req.person.LoginReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param username
     * @return
     */
    @RequestMapping(value = "/getNumber")
    public RspInfo getNumber( @Valid String username) {
        return loginService.getNumber(username);
    }

    /**
     * 用户登录
     * @param reqInfo
     * @return
     */
    @RequestMapping(value = "/userLogin")
    public RspInfo login( @Valid LoginReq reqInfo) {
        return loginService.toMain(reqInfo);
    }

}
