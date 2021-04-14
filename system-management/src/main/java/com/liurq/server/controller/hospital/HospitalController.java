package com.liurq.server.controller.hospital;

import com.github.pagehelper.PageInfo;
import com.liurq.server.model.Hospital;
import com.liurq.server.restful.req.hospital.*;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.SelectHospitalRsp;
import com.liurq.server.service.HospitalService;
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
 * @Date:2021-02-13
 * @Desc:
 **/
@RestController
@RequestMapping("/server/hospital")
@Api(description = "医院信息控制器")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/selectHospital",method = RequestMethod.POST)
    @ApiOperation(value = "搜索医院",notes = "搜索医院")
    public RspInfo<PageInfo<Hospital>> selectHospital(@RequestBody @Valid SelectHospitalReq req){
        return hospitalService.selectHospital(req);
    }

    @RequestMapping(value = "/selectHospitalByDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "通过科室id搜索医院",notes = "通过科室id搜索医院")
    public RspInfo<PageInfo<SelectHospitalRsp>> selectHospitalByDepartment(@RequestBody @Valid SelectHospitalByDepartmentReq req){
        return hospitalService.selectHospitalByDepartment(req);
    }

    @RequestMapping(value = "/modifyHospitalInfo",method = RequestMethod.POST)
    @ApiOperation(value = "修改医院信息",notes = "修改医院信息")
    public RspInfo<String> modifyHospitalInfo(@RequestBody @Valid ModifyHospitalInfoReq req){
        return hospitalService.modifyHospitalInfo(req);
    }

    @RequestMapping(value = "/updateHospitalDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "更新医院下的科室信息",notes = "更新医院下的科室信息")
    public RspInfo<String> updateHospitalDepartment(@RequestBody @Valid UpdateHospitalDepartmentReq req){
        return hospitalService.updateHospitalDepartment(req.getDepartmentList(),req.getHospitalId());
    }

    @RequestMapping(value = "/addMajorDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "添加医院的主攻科室",notes = "添加医院的主攻科室")
    public RspInfo<String> addMajorDepartment(@RequestBody @Valid MajorDepartmentReq req){
        return hospitalService.updateMajorDepartment(req,"1");
    }

    @RequestMapping(value = "/removeMajorDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "移除医院的主攻科室",notes = "移除医院的主攻科室")
    public RspInfo<String> removeMajorDepartment(@RequestBody @Valid MajorDepartmentReq req){
        return hospitalService.updateMajorDepartment(req,"0");
    }
}
