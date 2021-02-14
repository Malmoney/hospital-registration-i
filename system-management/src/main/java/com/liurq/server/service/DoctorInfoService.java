package com.liurq.server.service;

import com.github.pagehelper.PageInfo;
import com.liurq.server.model.Doctor;
import com.liurq.server.restful.req.system.hospital.SelectDoctorReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.SelectDoctorRsp;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-14
 * @Desc:
 **/
public interface DoctorInfoService {

    /**
     * 根据条件查询医生信息
     * @param req
     * @return
     */
    RspInfo<PageInfo<SelectDoctorRsp>>  selectDoctor(SelectDoctorReq req);

}
