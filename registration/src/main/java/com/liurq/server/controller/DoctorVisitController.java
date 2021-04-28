package com.liurq.server.controller;

import com.liurq.server.model.DoctorVisit;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.reg.*;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.reg.DoctorVisitRsp;
import com.liurq.server.restful.rsp.reg.VisitItem;
import com.liurq.server.restful.rsp.reg.VisitListRsp;
import com.liurq.server.service.DoctorVisitService;
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
 * @Date:2021-04-20
 * @Desc:
 **/
@RestController
@RequestMapping("/server/visit")
@Api(description = "医生出诊控制器")
public class DoctorVisitController {

    @Autowired
    private DoctorVisitService doctorVisitService;

    @ApiOperation(value = "添加医生出诊",notes = "添加医生出诊")
    @RequestMapping(value = "/addDoctorVisit",method = RequestMethod.POST)
    public RspInfo<String> addDoctorVisit(@RequestBody @Valid AddVisitReq req){
        return doctorVisitService.addDoctorVisit(req);
    }

    @ApiOperation(value = "查询挂号详情",notes = "查询挂号详情")
    @RequestMapping(value = "/selectVisitList",method = RequestMethod.POST)
    public RspInfo<List<VisitListRsp>> selectVisitList(@RequestBody @Valid DoctorIdReq req){
        return this.doctorVisitService.selectVisitList(req);
    }

    @ApiOperation(value = "查询医生挂号列表",notes = "查询医生挂号列表")
    @RequestMapping(value = "/selectDoctorVisitList",method = RequestMethod.POST)
    public RspInfo<List<DoctorVisitRsp>> selectDoctorVisitList(@RequestBody @Valid DoctorIdReq req){
        return this.doctorVisitService.selectDoctorVisitList(req.getDoctorId());
    }
    @ApiOperation(value = "查询挂号详情",notes = "查询挂号详情")
    @RequestMapping(value = "/selectRegList",method = RequestMethod.POST)
    public RspInfo<List<VisitItem>> selectRegList(@RequestBody @Valid VisitIdReq req){
        return this.doctorVisitService.selectRegList(req.getVisitId());
    }

    @ApiOperation(value = "叫号",notes = "叫号")
    @RequestMapping(value = "/nextNum",method = RequestMethod.POST)
    public RspInfo<String> nextNum(@RequestBody @Valid PassNumReq req){
        return this.doctorVisitService.nextNum(req);
    }

    @ApiOperation(value = "过号",notes = "过号")
    @RequestMapping(value = "/passNum",method = RequestMethod.POST)
    public RspInfo<String> passNum(@RequestBody @Valid PassNumReq req){
        return this.doctorVisitService.passNum(req);
    }

    @ApiOperation(value = "结束叫号",notes = "结束叫号")
    @RequestMapping(value = "/endVisit",method = RequestMethod.POST)
    public RspInfo<String> endVisit(@RequestBody @Valid VisitIdReq req){
        return this.doctorVisitService.endVisit(req);
    }

}