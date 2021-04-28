package com.liurq.server.controller.user;

import com.liurq.server.restful.req.user.AddPatientReq;
import com.liurq.server.restful.req.user.PatientIdReq;
import com.liurq.server.restful.req.user.SaveUserInfoReq;
import com.liurq.server.restful.req.user.UserIdReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
@RestController
@RequestMapping("/server/patient")
@Api(description = "就诊人信息控制器")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/addPatient",method = RequestMethod.POST)
    @ApiOperation(value = "添加就诊人信息",notes = "添加就诊人信息")
    public RspInfo SaveUserInfo(@RequestBody @Valid AddPatientReq req){
        return this.patientService.addPatient(req);
    }

    @RequestMapping(value = "/removePatient",method = RequestMethod.POST)
    @ApiOperation(value = "移除就诊人信息",notes = "移除就诊人信息")
    public RspInfo removePatient(@RequestBody @Valid PatientIdReq req){
        return this.patientService.removePatient(req);
    }

    @RequestMapping(value = "/selectPatientByUserId",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户就诊人信息",notes = "查询用户就诊人信息")
    public RspInfo selectPatientByUserId(@RequestBody @Valid UserIdReq req){
        return this.patientService.selectPatientByUserId(req);
    }

    @RequestMapping(value = "/selectPatientInfo",method = RequestMethod.POST)
    @ApiOperation(value = "查询就诊人信息",notes = "查询就诊人信息")
    public RspInfo selectPatientInfo(@RequestBody @Valid PatientIdReq req){
        return this.patientService.selectPatientInfo(req);
    }

}
