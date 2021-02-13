package com.liurq.server.service.impl;

import com.liurq.server.dao.DepartmentMapper;
import com.liurq.server.model.Department;
import com.liurq.server.model.DepartmentExample;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.DepartmentService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询所有可用科室
     *
     * @return
     */
    @Override
    public RspInfo<List<Department>> selectAllDepartment() {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andStatusEqualTo("0");
        List<Department> result = departmentMapper.selectByExample(departmentExample);
        if(ObjectUtils.isEmpty(result)){
            return RspInfo.success(new ArrayList<Department>());
        }
        return RspInfo.success(result);

    }
}
