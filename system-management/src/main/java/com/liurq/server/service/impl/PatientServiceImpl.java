package com.liurq.server.service.impl;

import com.liurq.server.dao.PatientMapper;
import com.liurq.server.model.Patient;
import com.liurq.server.restful.req.user.AddPatientReq;
import com.liurq.server.restful.req.user.PatientIdReq;
import com.liurq.server.restful.req.user.UserIdReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.PatientService;
import com.liurq.util.IDCardUtil;
import com.liurq.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;


    /**
     * 添加就诊人
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> addPatient(AddPatientReq req) {
        Date now = new Date();
        Patient patient = new Patient();
        patient.setPatientId(IDUtils.genUUId());
        patient.setPatientIdCard(req.getIdCard());
        patient.setPatientName(req.getName());
        patient.setPatientParentId(req.getUserId());
        patient.setPatientPhone(req.getPhone());
        patient.setPatientAddress(req.getAddress());
        patient.setPatientRelation(req.getRelation());
        patient.setPatientSex(IDCardUtil.getSex(req.getIdCard()));
        patient.setPatientBirthday(IDCardUtil.getBirth(req.getIdCard()));
        patient.setCreateDate(now);
        patient.setUpdateDate(now);
        patient.setStatus("0");
        patientMapper.insert(patient);

        return RspInfo.success("成功");
    }

    /**
     * 移除就诊人
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> removePatient(PatientIdReq req) {
        this.patientMapper.updatePatientStatus(req.getPatientId(),"1");
        return RspInfo.success("成功");
    }

    /**
     * 查询用户下的就诊人信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<List<Patient>> selectPatientByUserId(UserIdReq req) {
        List<Patient> result = this.patientMapper.selectPatientByUserId(req.getUserId());
        return RspInfo.success(result);
    }

    /**
     * 查询就诊人信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<Patient> selectPatientInfo(PatientIdReq req) {
        Patient patient = this.patientMapper.selectByPrimaryKey(req.getPatientId());
        return RspInfo.success(patient);
    }
}
