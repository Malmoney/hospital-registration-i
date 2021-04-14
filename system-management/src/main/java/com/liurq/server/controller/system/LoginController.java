package com.liurq.server.controller.system;

import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.restful.req.user.UserLoginReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.LoginService;
import com.liurq.server.service.UserService;
import com.liurq.util.IDUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @Author:hyz
 * @Date:2021-02-05
 * @Desc:登录控制器
 **/
@RestController
@RequestMapping("/server/login")
@Api(description = "登录控制器")
public class LoginController {


    @Autowired
    private LoginService loginService;
    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;
    @Autowired
    private UserService userService;
    /**
     * 获取验证码
     * @param userPhone
     * @return
     */
    @RequestMapping(value = "/getNumber",method = RequestMethod.POST)
    @ApiOperation(value = "获取验证码",notes = "获取验证码")
    public RspInfo getNumber( String userPhone) {
        return loginService.getNumber(userPhone);
    }

    /**
     * 获取验证码
     * @param req
     * @return
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录",notes = "用户登录")
    public RspInfo userLogin(@RequestBody @Valid UserLoginReq req) {
        String userPhone = req.getUserPhone();
        String authCode = req.getAuthCode();
        String code = personRedisFeignClient.getAuthCode(req.getUserPhone());
        if (StringUtils.isEmpty(code) || !code.equals(authCode)){
            return RspInfo.fail("2001","手机号或验证码不正确");
        }
        //移除redis中的验证码
        personRedisFeignClient.removeAuthCode(userPhone);
        //向redis中存储Token
        String token = IDUtils.genUUId();
        personRedisFeignClient.setUser(userPhone,token);
        return RspInfo.success(token);
    }


}
