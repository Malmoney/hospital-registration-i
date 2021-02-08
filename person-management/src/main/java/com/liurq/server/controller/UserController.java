package com.liurq.server.controller;

import com.liurq.server.restful.req.person.SaveUserInfoReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:hyz
 * @Date:2021-02-08
 * @Desc:
 **/
@RestController
@RequestMapping("/server/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/saveUserInfo")
    public RspInfo SaveUserInfo(SaveUserInfoReq req){
        userService.saveUserInfo();
    }


}
