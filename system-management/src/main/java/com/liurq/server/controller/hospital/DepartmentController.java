package com.liurq.server.controller.hospital;

import com.liurq.server.model.Department;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/selectAllDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有部门",notes = "查询所有部门")
    public RspInfo<List<Department>> selectAllDepartment(){
        return departmentService.selectAllDepartment();
    }

}
