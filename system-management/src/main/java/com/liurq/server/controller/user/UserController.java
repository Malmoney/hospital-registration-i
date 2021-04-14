package com.liurq.server.controller.user;

import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.model.User;
import com.liurq.server.restful.req.user.SaveUserInfoReq;
import com.liurq.server.restful.req.user.TokenReq;
import com.liurq.server.restful.req.user.UserPhoneReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author:hyz
 * @Date:2021-02-08
 * @Desc:
 **/
@RestController
@RequestMapping("/server/user")
@Api(description = "用户信息控制器")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;

    @RequestMapping(value = "/saveUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "保存用户信息",notes = "保存用户信息")
    public RspInfo SaveUserInfo(@RequestBody @Valid SaveUserInfoReq req){
        return userService.saveUserInfo(req);
    }

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户信息",notes = "查询用户信息")
    public RspInfo<User> getUserInfo(@RequestBody @Valid TokenReq req){
        String userPhone = personRedisFeignClient.getUser(req.getToken());
        User userInfo = userService.getUserInfo(userPhone);
        return RspInfo.success(userInfo);
    }

}
