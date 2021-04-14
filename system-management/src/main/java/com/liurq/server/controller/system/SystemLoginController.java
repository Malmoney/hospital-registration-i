package com.liurq.server.controller.system;

import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.restful.req.system.LoginReq;
import com.liurq.server.restful.req.user.UserLoginReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.MemberService;
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
 * @Date:2021-04-14
 * @Desc:
 **/
@RestController
@RequestMapping("/login")
@Api(description = "登录控制器")
public class SystemLoginController {

    @Autowired
    private MemberService memberService;

    /**
     * 获取验证码
     * @param req
     * @return
     */
    @RequestMapping(value = "/sysLogin",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录",notes = "用户登录")
    public RspInfo<String> userLogin(@RequestBody @Valid LoginReq req) {
        return this.memberService.systemLogin(req);
    }

}
