package com.liurq.server.controller.hospital;

import com.liurq.server.model.Department;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:
 **/
@RestController
@RequestMapping("/server/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/selectAllDepartment")
    public RspInfo<List<Department>> selectAllDepartment(){
        return departmentService.selectAllDepartment();
    }

}
