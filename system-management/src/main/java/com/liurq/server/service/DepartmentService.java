package com.liurq.server.service;

import com.liurq.server.model.Department;
import com.liurq.server.restful.rsp.RspInfo;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:
 **/
public interface DepartmentService {

    /**
     * 查询所有可用科室
     * @return
     */
    RspInfo<List<Department>> selectAllDepartment();

}
