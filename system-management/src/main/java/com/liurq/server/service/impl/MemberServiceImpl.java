package com.liurq.server.service.impl;

import com.liurq.server.dao.DoctorMapper;
import com.liurq.server.dao.HospitalMapper;
import com.liurq.server.dao.MemberMapper;
import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.model.Doctor;
import com.liurq.server.model.Hospital;
import com.liurq.server.model.Member;
import com.liurq.server.restful.req.system.*;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.AddHospitalAccountRsp;
import com.liurq.server.service.MemberService;
import com.liurq.util.IDUtils;
import com.liurq.util.PasswordUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author:hyz
 * @Date:2021-03-31
 * @Desc:
 **/
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private HospitalMapper hospitalMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;

    /**
     * 添加管理员用户
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> addAdminAccount(AddAdminAccountReq req) {
        this.insertMember(req,"");
        return RspInfo.success("成功");
    }

    /**
     * 添加医院管理员账户
     *
     * @param req
     * @return
     */
    @Override
    public AddHospitalAccountRsp addHospitalAccount(AddHospitalAccountReq req, String parentId) {
        boolean isParent = false;
        AddHospitalAccountRsp rsp = new AddHospitalAccountRsp();
        ArrayList<AddHospitalAccountRsp> childs = new ArrayList<>();
        if (!ObjectUtils.isEmpty(req.getChilds())){
            isParent = true;
        }
        String hospitalId= IDUtils.genUUId();
        //添加账号信息
        String memberId = insertMember(req,hospitalId);

        //保存医院信息
        Hospital hospital = new Hospital();
        hospital.setHospitalId(hospitalId);
        hospital.setHospitalLevel(req.getHospitalLevel());
        hospital.setHospitalName(req.getHospitalName());
        hospital.setStatus("0");
        if (!isParent){//不是父节点
            hospital.setParentId(parentId);
            hospital.setHaschild("0");
            hospitalMapper.insertSelective(hospital);
            //封装响应信息
            rsp.setHospitalId(hospitalId);
            rsp.setHospitalLevel(req.getHospitalLevel());
            rsp.setHospitalName(req.getHospitalName());
            rsp.setUserName(req.getUserName());
            rsp.setChilds(null);
            return rsp;
        }else {//是父节点
            hospital.setParentId(parentId);
            hospital.setHaschild("1");
            hospitalMapper.insertSelective(hospital);
            for (AddHospitalAccountReq reqs : req.getChilds()){
                reqs.setParentId(memberId);
                childs.add(this.addHospitalAccount(reqs,hospitalId));
            }

            return rsp;
        }
    }


    /**
     * 添加医生账户
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> addDoctorAccount(AddDoctorAccountReq req) {
        String doctorId = IDUtils.genUUId();
        //添加账号信息
        String memberId = insertMember(req,doctorId);
        //添加医生信息
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);
        doctor.setDoctorLevel(req.getDoctorLevel());
        doctor.setDoctorName(req.getDoctorName());
        doctor.setDoctorSex(req.getDoctorSex());
        doctorMapper.insertSelective(doctor);
        return RspInfo.success("成功");
    }

    /**
     * 修改账号密码
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> modifyPassword(ModifyPasswordReq req) {
        //查询旧密码
        Member member = memberMapper.selectByPrimaryKey(req.getMemberId());
        if (!PasswordUtil.getPassword(req.getOldPassword()).equals(member.getPassword())){
            return RspInfo.fail("旧密码不正确");
        }
        member.setPassword(PasswordUtil.getPassword(req.getPassword()));
        member.setUpdateDate(new Date());
        memberMapper.updateByPrimaryKeySelective(member);
        //修改为新密码
        return RspInfo.success("成功");
    }

    /**
     * 首次修改账号密码
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> modifyPasswordFirstTime(ModifyPasswordReq req) {
        //查询旧密码
        Member member = memberMapper.selectByPrimaryKey(req.getMemberId());
        if (!PasswordUtil.getPassword(req.getUserName()+"123456").equals(member.getPassword())){
            return RspInfo.fail("修改失败！");
        }
        member.setPassword(PasswordUtil.getPassword(req.getPassword()));
        member.setUpdateDate(new Date());
        memberMapper.updateByPrimaryKeySelective(member);
        //修改为新密码
        return RspInfo.success("成功");
    }

    /**
     * 系统登录
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> systemLogin(LoginReq req) {
        String password = PasswordUtil.getPassword(req.getPassword());
        String username = req.getUsername();

        Member member = memberMapper.selectByUserName(username);
        if (!ObjectUtils.isEmpty(member) && password.equals(member.getPassword())){
            String token = IDUtils.genUUId();
            personRedisFeignClient.setUser(member.getMemberName(),token);
            return RspInfo.success(token);
        }
        return RspInfo.fail("3001","用户名或密码不正确");
    }

    private String insertMember(CommonAccountReq req, String infoId){
        String memberId = IDUtils.genUUId();
        Date now = new Date();
        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberName(req.getUserName());
        member.setPassword(PasswordUtil.getPassword(req.getUserName()+"123456"));
        member.setMemberParent(req.getParentId());
        member.setType(req.getType());
        member.setStatus("0");
        member.setInfoId(infoId);
        member.setCreateDate(now);
        member.setUpdateDate(now);
        memberMapper.insertSelective(member);
        return memberId;
    }

}
