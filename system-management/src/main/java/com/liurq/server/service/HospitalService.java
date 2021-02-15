package com.liurq.server.service;

import com.github.pagehelper.PageInfo;
import com.liurq.server.model.Hospital;
import com.liurq.server.restful.req.system.hospital.SelectHospitalByDepartmentReq;
import com.liurq.server.restful.req.system.hospital.SelectHospitalReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.SelectHospitalRsp;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:
 **/
public interface HospitalService {

    /**
     * 根据条件查询医院信息
     * @param req
     * @return
     */
    RspInfo<PageInfo<Hospital>> selectHospital(SelectHospitalReq req);

    /**
     * 根据科室查询医院
     * @param req
     * @return
     */
    RspInfo<PageInfo<SelectHospitalRsp>> selectHospitalByDepartment(SelectHospitalByDepartmentReq req);
}
