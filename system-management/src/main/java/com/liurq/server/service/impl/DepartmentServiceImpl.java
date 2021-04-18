package com.liurq.server.service.impl;

import com.liurq.server.dao.DepartmentMapper;
import com.liurq.server.dao.HospitalDepartmentMapper;
import com.liurq.server.model.Department;
import com.liurq.server.model.DepartmentExample;
import com.liurq.server.model.HospitalDepartment;
import com.liurq.server.model.HospitalDepartmentExample;
import com.liurq.server.restful.req.hospital.DepartmentHospitalReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.SelectDepartmentRsp;
import com.liurq.server.service.DepartmentService;
import com.liurq.util.IDUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private HospitalDepartmentMapper hospitalDepartmentMapper;
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

    /**
     * 查询医院下的所有可是
     *
     * @param hospitalId
     * @return
     */
    @Override
    public RspInfo<List<Department>> selectDepartByHospitalId(String hospitalId) {
        return RspInfo.success(departmentMapper.selectByHospitalId(hospitalId));
    }

    /**
     * 查询科室带医院
     *
     * @param hospitalId
     * @return
     */
    @Override
    public RspInfo<List<SelectDepartmentRsp>> selectDepart(String hospitalId) {
        List<SelectDepartmentRsp> result = departmentMapper.selectDepart(hospitalId);
        return RspInfo.success(result);
    }

    /**
     * 新开设科室
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> addDepartment(DepartmentHospitalReq req) {
        Date now = new Date();
        HospitalDepartment hospitalDepartment = new HospitalDepartment();
        hospitalDepartment.setId(IDUtils.genUUId());
        hospitalDepartment.setDepartmentId(req.getDepartmentId());
        hospitalDepartment.setHospitalId(req.getHospitalId());
        hospitalDepartment.setStatus("0");
        hospitalDepartment.setCreateDate(now);
        hospitalDepartment.setUpdateDate(now);
        this.hospitalDepartmentMapper.insertSelective(hospitalDepartment);
        return RspInfo.success("成功");
    }

    /**
     * 启用科室
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> enableDepartment(DepartmentHospitalReq req) {
        this.hospitalDepartmentMapper.updateStatus(req.getHospitalId(),req.getDepartmentId(),"0");
        return RspInfo.success("成功");
    }

    /**
     * 禁用科室
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> banDepartment(DepartmentHospitalReq req) {
        this.hospitalDepartmentMapper.updateStatus(req.getHospitalId(),req.getDepartmentId(),"1");
        return RspInfo.success("成功");
    }


}
