package com.liurq.server.controller.hospital;

import com.github.pagehelper.PageInfo;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.hospital.ModifyDoctorInfoReq;
import com.liurq.server.restful.req.hospital.ModifyHospitalInfoReq;
import com.liurq.server.restful.req.hospital.SelectDoctorReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.DoctorInfoRsp;
import com.liurq.server.restful.rsp.hospital.SelectDoctorRsp;
import com.liurq.server.service.DoctorInfoService;
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
 * @Date:2021-02-14
 * @Desc:
 **/
@RestController
@RequestMapping("/server/doctor")
@Api(description = "医生信息控制器")
public class DoctorInfoController {

    @Autowired
    private DoctorInfoService doctorInfoService;

    @RequestMapping(value = "/selectDoctor",method = RequestMethod.POST)
    @ApiOperation(value = "搜索医生",notes = "搜索医生")
    public RspInfo<PageInfo<SelectDoctorRsp>> selectDoctor(@RequestBody @Valid SelectDoctorReq req){
        return doctorInfoService.selectDoctor(req);
    }

    @RequestMapping(value = "/selectDoctorInfo",method = RequestMethod.POST)
    @ApiOperation(value = "根据doctorId查询医生详情",notes = "根据doctorId查询医生详情")
    public RspInfo<DoctorInfoRsp> selectDoctor(@RequestBody @Valid DoctorIdReq req){
        return doctorInfoService.selectDoctorInfo(req);
    }

    @RequestMapping(value = "/modifyDoctorInfo",method = RequestMethod.POST)
    @ApiOperation(value = "修改医生信息",notes = "修改医生信息")
    public RspInfo<String> modifyDoctorInfo(@RequestBody @Valid ModifyDoctorInfoReq req){
        return doctorInfoService.modifyDoctorInfo(req);
    }

}
