package com.liurq.server.service;

import com.liurq.server.model.Hospital;
import com.liurq.server.restful.req.system.hospital.SelectHospitalReq;
import com.liurq.server.restful.rsp.RspInfo;

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
    RspInfo<List<Hospital>> selectHospital(SelectHospitalReq req);

}
