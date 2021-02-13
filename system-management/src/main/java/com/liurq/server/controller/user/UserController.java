package com.liurq.server.controller.user;

import com.liurq.server.restful.req.system.user.SaveUserInfoReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return userService.saveUserInfo(req);
    }

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public RspInfo getUserInfo(@AuthenticationPrincipal UserDetails user){
        return userService.getUserInfo(user);
    }

}
