package com.liurq.server.controller.hospital;

import com.liurq.server.model.Department;
import com.liurq.server.model.Hospital;
import com.liurq.server.restful.req.hospital.DepartmentHospitalReq;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.hospital.HospitalIdReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.SelectDepartmentRsp;
import com.liurq.server.service.DepartmentService;
import com.liurq.server.service.DoctorInfoService;
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
 * @Date:2021-02-13
 * @Desc:
 **/
@RestController
@RequestMapping("/server/department")
@Api(description = "科室控制器")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DoctorInfoService doctorInfoService;

    @RequestMapping(value = "/selectAllDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有部门",notes = "查询所有部门")
    public RspInfo<List<Department>> selectAllDepartment(){
        return departmentService.selectAllDepartment();
    }

    @RequestMapping(value = "/selectDepartByHospitalId",method = RequestMethod.POST)
    @ApiOperation(value = "查询医院下的科室",notes = "查询所有部门")
    public RspInfo<List<Department>> selectDepartByHospitalId(@RequestBody @Valid HospitalIdReq req){
        return departmentService.selectDepartByHospitalId(req.getHospitalId());
    }

    @RequestMapping(value = "/selectDepartByDoctorId",method = RequestMethod.POST)
    @ApiOperation(value = "查询医院下的科室",notes = "查询所有部门")
    public RspInfo<List<Department>> selectDepartByDoctorId(@RequestBody @Valid DoctorIdReq req){
        Hospital hospital = doctorInfoService.selectHospitalByDoctor(req.getDoctorId());
        return departmentService.selectDepartByHospitalId(hospital.getHospitalId());
    }

    @RequestMapping(value = "/selectDepart",method = RequestMethod.POST)
    @ApiOperation(value = "查询科室带医院",notes = "查询科室带医院")
    public RspInfo<List<SelectDepartmentRsp>> selectDepart(@RequestBody @Valid HospitalIdReq req){
        return departmentService.selectDepart(req.getHospitalId());
    }

    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "新开设科室",notes = "新开设科室")
    public RspInfo<String> addDepartment(@RequestBody @Valid DepartmentHospitalReq req){
        return departmentService.addDepartment(req);
    }

    @RequestMapping(value = "/enableDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "启用科室",notes = "启用科室")
    public RspInfo<String> enableDepartment(@RequestBody @Valid DepartmentHospitalReq req){
        return departmentService.enableDepartment(req);
    }

    @RequestMapping(value = "/banDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "禁用科室",notes = "禁用科室")
    public RspInfo<String> banDepartment(@RequestBody @Valid DepartmentHospitalReq req){
        return departmentService.banDepartment(req);
    }

}
