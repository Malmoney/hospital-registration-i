package com.liurq.server.service;

import com.liurq.server.model.Patient;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.reg.RegIdReq;
import com.liurq.server.restful.req.reg.UserRegistrationReq;
import com.liurq.server.restful.req.user.UserIdReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.reg.RegistrationInfoRsp;
import com.liurq.server.restful.rsp.reg.RegistrationListRsp;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
public interface RegistrationService {

    /**
     * 用户挂号
     * @param req
     * @return
     */
    RspInfo<String> userRegistration(UserRegistrationReq req);

    /**
     * 查询用户挂号记录
     * @param req
     * @return
     */
    RspInfo<List<RegistrationListRsp>> selectRegistrationList(UserIdReq req);

    /**
     * 查询医生当前的挂号
     * @param req
     * @return
     */
    RspInfo<RegistrationInfoRsp> selectTodayReg(DoctorIdReq req);

    /**
     * 根据挂号id查询患者信息
     * @param req
     * @return
     */
    RspInfo<Patient> selectPatientIdByRegId(RegIdReq req);

}
