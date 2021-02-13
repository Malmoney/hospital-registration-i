package com.liurq.server.controller.system;

import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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



}
