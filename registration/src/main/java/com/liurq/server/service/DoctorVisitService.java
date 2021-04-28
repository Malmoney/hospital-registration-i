package com.liurq.server.service;

import com.liurq.server.model.DoctorVisit;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.reg.AddVisitReq;
import com.liurq.server.restful.req.reg.PassNumReq;
import com.liurq.server.restful.req.reg.VisitIdReq;
import com.liurq.server.restful.rsp.reg.DoctorVisitRsp;
import com.liurq.server.restful.rsp.reg.VisitItem;
import com.liurq.server.restful.rsp.reg.VisitListRsp;
import com.liurq.server.restful.rsp.RspInfo;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-20
 * @Desc:
 **/
public interface DoctorVisitService {

    /**
     * 添加医生出诊
     * @param req
     * @return
     */
    RspInfo<String> addDoctorVisit(AddVisitReq req);

    /**
     * 查看医生可挂号列表
     * @param req
     * @return
     */
    RspInfo<List<VisitListRsp>> selectVisitList(DoctorIdReq req);

    /**
     * 叫号
     * @param req
     * @return
     */
    RspInfo<String> nextNum(PassNumReq req);

    /**
     * 过号
     * @param req
     * @return
     */
    RspInfo<String> passNum(PassNumReq req);

    /**
     * 过号
     * @param req
     * @return
     */
    RspInfo<String> endVisit(VisitIdReq req);

    /**
     * 查询医生的出诊安排
     * @param doctorId
     * @return
     */
    RspInfo<List<DoctorVisitRsp>> selectDoctorVisitList(String doctorId);

    /**
     * 查询挂号的详情
     * @param visitId
     * @return
     */
    RspInfo<List<VisitItem>> selectRegList(String visitId);
}
