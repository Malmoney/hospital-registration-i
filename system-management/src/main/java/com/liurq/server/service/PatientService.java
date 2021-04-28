package com.liurq.server.service;

import com.liurq.server.model.Patient;
import com.liurq.server.restful.req.user.AddPatientReq;
import com.liurq.server.restful.req.user.PatientIdReq;
import com.liurq.server.restful.req.user.UserIdReq;
import com.liurq.server.restful.rsp.RspInfo;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
public interface PatientService {

    /**
     * 添加就诊人
     * @param req
     * @return
     */
    RspInfo<String> addPatient(AddPatientReq req);

    /**
     * 移除就诊人
     * @param req
     * @return
     */
    RspInfo<String> removePatient(PatientIdReq req);

    /**
     * 查询用户下的就诊人信息
     * @return
     */
    RspInfo<List<Patient>> selectPatientByUserId(UserIdReq req);

    /**
     * 查询就诊人信息
     * @param req
     * @return
     */
    RspInfo<Patient> selectPatientInfo(PatientIdReq req);
}
