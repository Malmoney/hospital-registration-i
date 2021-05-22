package com.liurq.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liurq.server.dao.DoctorMapper;
import com.liurq.server.dao.HospitalMapper;
import com.liurq.server.dao.MajorMapper;
import com.liurq.server.model.*;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.hospital.ModifyDoctorInfoReq;
import com.liurq.server.restful.req.hospital.SelectDoctorReq;
import com.liurq.server.restful.req.hospital.SelectVisitDoctorReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.DoctorInfoRsp;
import com.liurq.server.restful.rsp.hospital.DoctorVisitRsp;
import com.liurq.server.restful.rsp.hospital.SelectDoctorRsp;
import com.liurq.server.service.DoctorInfoService;
import com.liurq.util.IDUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-14
 * @Desc:
 **/
@Service
public class DoctorInfoServiceImpl implements DoctorInfoService {

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private HospitalMapper hospitalMapper;

    /**
     * 根据条件查询医生信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<PageInfo<SelectDoctorRsp>> selectDoctor(@Valid SelectDoctorReq req) {
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<SelectDoctorRsp> result = doctorMapper.selectDoctor(req);
        if (ObjectUtils.isEmpty(result)){
            result = new ArrayList<>();
        }
        PageInfo<SelectDoctorRsp> pageInfo = new PageInfo<>(result);
        return RspInfo.success(pageInfo);
    }

    /**
     * 根据条件查询医生信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<PageInfo<SelectDoctorRsp>> selectVisitDoctor(SelectVisitDoctorReq req) {
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<SelectDoctorRsp> result = doctorMapper.selectVisitDoctor(req);
        if (ObjectUtils.isEmpty(result)){
            result = new ArrayList<>();
        }
        PageInfo<SelectDoctorRsp> pageInfo = new PageInfo<>(result);
        return RspInfo.success(pageInfo);
    }

    /**
     * 根据id查询医生的出诊信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<List<DoctorVisit>> selectDoctorVisitInfo(DoctorVisitRsp req) {
        return null;
    }

    /**
     * 根据id查询医生的详细信息
     * @param req
     * @return
     */
    @Override
    public RspInfo<DoctorInfoRsp> selectDoctorInfo(DoctorIdReq req){
        DoctorInfoRsp rsp = this.doctorMapper.selectDoctorInfo(req.getDoctorId());
        return RspInfo.success(rsp);
    }

    /**
     * 修改医生信息
     *
     * @param req
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RspInfo<String> modifyDoctorInfo(ModifyDoctorInfoReq req) {
        Date now = new Date();
        //修改医生主体信息
        Doctor doctor = new Doctor();
        doctor.setDoctorId(req.getDoctorId());
        doctor.setDoctorWorkAge(req.getDoctorWorkAge());
        doctor.setDoctorFeedbackRate("0");
        doctor.setDoctorRegistrationCount(0);
        doctor.setDoctorImage(req.getDoctorImage());
        doctor.setDoctorPhone(req.getDoctorPhone());
        //doctor.setStatus("0");
        doctor.setCreateDate(now);
        doctor.setUpdateDate(now);
        doctor.setRemark(req.getRemark());
        doctorMapper.updateByPrimaryKeySelective(doctor);
        //修改医生主攻疾病
        //this.updateMajors(req.getMajor(), doctor.getDoctorId());

        return RspInfo.success("成功");
    }

    /**
     * 查看医生所属医院
     *
     * @param doctorId
     * @return
     */
    @Override
    public Hospital selectHospitalByDoctor(String doctorId) {
        Hospital hospital = hospitalMapper.selectHospitalIdByDoctorId(doctorId);
        return hospital;
    }

    /**
     * 更新医生的主攻
     * @param newMajor
     * @param doctorId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateMajors(List<Illness> newMajor,String doctorId){
        //查询旧主攻方向
        List<Illness> oldMajor = majorMapper.selectDoctorMajorByDoctorId(doctorId);
        if (ObjectUtils.isEmpty(oldMajor)){
            return this.saveDoctorMajor(newMajor,doctorId);
        }
        if (ObjectUtils.isEmpty(newMajor)){
            HashMap<String, Object> param = new HashMap<>();
            param.put("list",oldMajor);
            param.put("doctorId",doctorId);
            return this.majorMapper.deleteDoctorMajors(param);
        }
        ArrayList<Illness> removeFlags = new ArrayList<>();
        for (Illness illness:newMajor){
            for (int i =0;i<oldMajor.size();i++){
                if (oldMajor.get(i).getIllnessId().equals(illness.getIllnessId())){
                    removeFlags.add(illness);
                    oldMajor.remove(i);
                    break;
                }
            }
        }
        if(!ObjectUtils.isEmpty(removeFlags)){
            newMajor.removeAll(removeFlags);
        }
        //新增数据
        this.saveDoctorMajor(newMajor,doctorId);
        //删除不要的数据
        if(!ObjectUtils.isEmpty(oldMajor)){
            HashMap<String, Object> param = new HashMap<>();
            param.put("list",oldMajor);
            param.put("doctorId",doctorId);
            this.majorMapper.deleteDoctorMajors(param);
        }
        return 1;
    }

    /**
     * 保存医生的主攻信息
     * @return
     */
    private int saveDoctorMajor(List<Illness> majors,String doctorId){
        Date now = new Date();
        for (Illness illness : majors){
            Major major = new Major();
            major.setId(IDUtils.genUUId());
            major.setIllnessId(illness.getIllnessId());
            major.setDoctorId(doctorId);
            major.setDeleted("0");
            major.setCreateDate(now);
            major.setUpdateDate(now);
            majorMapper.insertSelective(major);
        }
        return 1;
    }
}
