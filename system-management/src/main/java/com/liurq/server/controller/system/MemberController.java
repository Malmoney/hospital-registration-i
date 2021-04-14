package com.liurq.server.controller.system;

import com.liurq.server.restful.req.system.AddAdminAccountReq;
import com.liurq.server.restful.req.system.AddDoctorAccountReq;
import com.liurq.server.restful.req.system.AddHospitalAccountReq;
import com.liurq.server.restful.req.system.ModifyPasswordReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.AddHospitalAccountRsp;
import com.liurq.server.service.MemberService;
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
 * @Date:2021-03-31
 * @Desc:
 **/
@RestController
@RequestMapping("/server/member")
@Api(description = "平台信息管理员账号处理")
public class MemberController {

    @Autowired
    private MemberService memberService;


    /**
     * 添加省级管理员
     * @param req
     * @return
     */
    @ApiOperation(value = "添加省级管理员账号",notes = "添加省级管理员账号")
    @RequestMapping(value = "/addProvAdmin",method = RequestMethod.POST)
    public RspInfo<String> addProvAdmin(@RequestBody @Valid AddAdminAccountReq req){
        req.setType("9");
        return memberService.addAdminAccount(req);
    }

    /**
     * 添加区县管理员
     * @param req
     * @return
     */
    @ApiOperation(value = "添加市级管理员账号",notes = "添加市级管理员账号")
    @RequestMapping(value = "/addCountyAdmin",method = RequestMethod.POST)
    public RspInfo<String> addCountyAdmin(@RequestBody @Valid AddAdminAccountReq req){
        req.setType("8");
        return memberService.addAdminAccount(req);
    }

    /**
     * 添加医院管理员
     * @param req
     * @return
     */
    @ApiOperation(value = "添加医院管理账号",notes = "添加医院管理账号")
    @RequestMapping(value = "/addHospitalAdmin",method = RequestMethod.POST)
    public RspInfo<String> addHospitalAdmin(@RequestBody @Valid AddHospitalAccountReq req){
        req.setType("1");
        AddHospitalAccountRsp rsp = memberService.addHospitalAccount(req, "0");
        return RspInfo.success("成功");
    }

    /**
     * 添加医生账号
     * @param req
     * @return
     */
    @ApiOperation(value = "添加医生账号",notes = "添加医生账号")
    @RequestMapping(value = "/addDoctorAccount",method = RequestMethod.POST)
    public RspInfo<String> addDoctorAccount(@RequestBody @Valid AddDoctorAccountReq req){
        req.setType("0");
        return memberService.addDoctorAccount(req);
    }

    /**
     * 修改账号密码
     * @param req
     * @return
     */
    @ApiOperation(value = "修改账号密码",notes = "修改账号密码")
    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST)
    public RspInfo<String> modifyPassword(@RequestBody @Valid ModifyPasswordReq req){
        if (StringUtils.isEmpty(req.getOldPassword())){
            return RspInfo.fail("旧密码不能为空");
        }
        return this.memberService.modifyPassword(req);
    }

    /**
     * 首次修改账号密码
     * @param req
     * @return
     */
    @ApiOperation(value = "首次修改账号密码",notes = "首次修改账号密码")
    @RequestMapping(value = "/modifyPasswordFirstTime",method = RequestMethod.POST)
    public RspInfo<String> modifyPasswordFirstTime(@RequestBody @Valid ModifyPasswordReq req){
        return this.memberService.modifyPasswordFirstTime(req);
    }
}
