package com.liurq.server.service.impl;

import com.liurq.server.dao.DoctorVisitMapper;
import com.liurq.server.dao.PatientMapper;
import com.liurq.server.dao.UserRegistrationMapper;
import com.liurq.server.dao.VisitRecordMapper;
import com.liurq.server.model.DoctorVisit;
import com.liurq.server.model.Patient;
import com.liurq.server.model.UserRegistration;
import com.liurq.server.model.VisitRecord;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.reg.RegIdReq;
import com.liurq.server.restful.req.reg.UserRegistrationReq;
import com.liurq.server.restful.req.user.UserIdReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.reg.RegistrationInfoRsp;
import com.liurq.server.restful.rsp.reg.RegistrationListRsp;
import com.liurq.server.service.RegistrationService;
import com.liurq.util.IDUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRegistrationMapper userRegistrationMapper;
    @Autowired
    private DoctorVisitMapper doctorVisitMapper;
    @Autowired
    private VisitRecordMapper visitRecordMapper;
    @Autowired
    private PatientMapper patientMapper;
    /**
     * 用户挂号
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> userRegistration(UserRegistrationReq req) {
        Date now = new Date();
        UserRegistration userRegistration = new UserRegistration();
        String regId = IDUtils.genUUId();
        userRegistration.setId(regId);
        userRegistration.setUserId(req.getUserId());
        userRegistration.setPatientId(req.getPatientId());
        userRegistration.setTime(req.getTime());
        userRegistration.setDoctorId(req.getDoctorId());
        userRegistration.setRegDate(now);
        userRegistration.setCreateDate(now);
        userRegistration.setUpdateDate(now);
        userRegistration.setNum(req.getNum());
        //0-等待中，1-已过号，2-已结束
        userRegistration.setStatus("0");
        userRegistration.setVisitId(req.getVisitId());
        this.userRegistrationMapper.insert(userRegistration);
        return RspInfo.success(regId);
    }

    /**
     * 查询用户挂号记录
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<List<RegistrationListRsp>> selectRegistrationList(UserIdReq req) {
        List<RegistrationListRsp> result = this.userRegistrationMapper.selectRegistrationList(req.getUserId());
        return RspInfo.success(result);
    }

    /**
     * 查询医生当前的挂号
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<RegistrationInfoRsp> selectTodayReg(DoctorIdReq req) {
        String doctorId = req.getDoctorId();
        //查询当前叫号
        Date date = new Date();
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(date);
        endDate.set(Calendar.HOUR_OF_DAY,23);
        endDate.set(Calendar.MINUTE,59);
        endDate.set(Calendar.SECOND,59);
        HashMap<String, Object> param = new HashMap<>();
        param.put("doctorId",doctorId);
        param.put("endDate",endDate.getTime());
        endDate.set(Calendar.HOUR_OF_DAY,0);
        endDate.set(Calendar.MINUTE,0);
        endDate.set(Calendar.SECOND,0);
        param.put("startDate",endDate.getTime());
        DoctorVisit nowVisit = doctorVisitMapper.selectNowVisit(param);
        if (ObjectUtils.isEmpty(nowVisit)){
            return RspInfo.success(null);
        }
        VisitRecord visitRecord = this.visitRecordMapper.selectByVisitId(nowVisit.getId());
        RegistrationInfoRsp rsp = new RegistrationInfoRsp();
        rsp.setVisitId(nowVisit.getId());
        rsp.setNowNum(0);
        if ("0".equals(visitRecord.getStatus())){
            rsp.setNowRegId(null);
        }else{
            //查询当前叫号的id
            UserRegistration nowReg = this.userRegistrationMapper.selectNowRegId(nowVisit.getId(),visitRecord.getNum());
            if (ObjectUtils.isEmpty(nowReg)){
                rsp.setNowNum(0);
                rsp.setNowRegId(null);
            }else{
                rsp.setNowRegId(nowReg.getId());
                rsp.setNowNum(nowReg.getNum());
            }
        }
        //查询下一个叫号的id
        UserRegistration nextReg = this.userRegistrationMapper.selectNextRegId(nowVisit.getId(), rsp.getNowNum());
        if (ObjectUtils.isEmpty(nextReg)){
            rsp.setNextRegId(null);
            rsp.setNextNum(0);
        }else{
            rsp.setNextRegId(nextReg.getId());
            rsp.setNextNum(nextReg.getNum());
        }
        return RspInfo.success(rsp);
    }

    /**
     * 根据挂号id查询患者信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<Patient> selectPatientIdByRegId(RegIdReq req) {
        Patient patient = this.patientMapper.selectByRegId(req.getRegId());
        return RspInfo.success(patient);
    }
}
