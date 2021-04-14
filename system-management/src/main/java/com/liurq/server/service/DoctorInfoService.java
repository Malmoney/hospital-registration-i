package com.liurq.server.service;

import com.github.pagehelper.PageInfo;
import com.liurq.server.model.DoctorVisit;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.hospital.ModifyDoctorInfoReq;
import com.liurq.server.restful.req.hospital.SelectDoctorReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.DoctorInfoRsp;
import com.liurq.server.restful.rsp.hospital.DoctorVisitRsp;
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

    /**
     * 根据id查询医生的出诊信息
     * @param req
     * @return
     */
    RspInfo<List<DoctorVisit>> selectDoctorVisitInfo(DoctorVisitRsp req);

    /**
     *  查询用户
     * @param req
     * @return
     */
    RspInfo<DoctorInfoRsp> selectDoctorInfo(DoctorIdReq req);

    /**
     * 修改医生信息
     * @param req
     * @return
     */
    RspInfo<String> modifyDoctorInfo(ModifyDoctorInfoReq req);
}
