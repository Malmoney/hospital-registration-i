package com.liurq.server.controller;

import com.liurq.server.model.Patient;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.reg.AddVisitReq;
import com.liurq.server.restful.req.reg.RegIdReq;
import com.liurq.server.restful.req.reg.UserRegistrationReq;
import com.liurq.server.restful.req.user.UserIdReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.reg.RegistrationInfoRsp;
import com.liurq.server.restful.rsp.reg.RegistrationListRsp;
import com.liurq.server.service.RegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
@RestController
@RequestMapping("/server/reg")
@Api(description = "挂号控制器")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @ApiOperation(value = "用户挂号",notes = "用户挂号")
    @RequestMapping(value = "/userRegistration",method = RequestMethod.POST)
    public RspInfo<String> userRegistration(@RequestBody @Valid UserRegistrationReq req){
        return registrationService.userRegistration(req);
    }

    @ApiOperation(value = "查询挂号信息详情",notes = "查询挂号信息详情")
    @RequestMapping(value = "/selectRegistrationInfo",method = RequestMethod.POST)
    public RspInfo<String> selectRegistrationInfo(@RequestBody @Valid RegIdReq req){
        return null;
    }

    @ApiOperation(value = "查询用户的挂号记录",notes = "查询用户的挂号记录")
    @RequestMapping(value = "/selectRegistrationList",method = RequestMethod.POST)
    public RspInfo<List<RegistrationListRsp>> selectRegistrationList(@RequestBody @Valid UserIdReq req){
        return this.registrationService.selectRegistrationList(req);
    }

    @ApiOperation(value = "查询医生当前的挂号",notes = "查询医生当前的挂号")
    @RequestMapping(value = "/selectTodayReg",method = RequestMethod.POST)
    public RspInfo<RegistrationInfoRsp> selectTodayReg(@RequestBody @Valid DoctorIdReq req){
        return this.registrationService.selectTodayReg(req);
    }

    @ApiOperation(value = "根据挂号id查询患者信息",notes = "根据挂号id查询患者信息")
    @RequestMapping(value = "/selectPatientIdByRegId",method = RequestMethod.POST)
    public RspInfo<Patient> selectPatientIdByRegId(@RequestBody @Valid RegIdReq req){
        return this.registrationService.selectPatientIdByRegId(req);
    }

}