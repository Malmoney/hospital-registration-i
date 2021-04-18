package com.liurq.server.service;

import com.liurq.server.model.Department;
import com.liurq.server.restful.req.hospital.DepartmentHospitalReq;
import com.liurq.server.restful.req.hospital.HospitalIdReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.SelectDepartmentRsp;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
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

    /**
     * 查询医院下的所有可是
     * @return
     */
    RspInfo<List<Department>> selectDepartByHospitalId(String hospitalId);

    /**
     * 查询科室带医院
     * @param hospitalId
     * @return
     */
    RspInfo<List<SelectDepartmentRsp>> selectDepart(String hospitalId);

    /**
     * 新开设科室
     * @param req
     * @return
     */
    RspInfo<String> addDepartment(DepartmentHospitalReq req);

    /**
     * 启用科室
     * @param req
     * @return
     */
    RspInfo<String> enableDepartment(DepartmentHospitalReq req);

    /**
     * 禁用科室
     * @param req
     * @return
     */
    RspInfo<String> banDepartment(DepartmentHospitalReq req);

}
