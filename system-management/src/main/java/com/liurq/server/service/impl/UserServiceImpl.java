package com.liurq.server.service.impl;

import com.liurq.server.dao.PatientMapper;
import com.liurq.server.dao.UserMapper;
import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.model.Patient;
import com.liurq.server.model.User;
import com.liurq.server.restful.req.person.SaveUserInfoReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.UserService;
import com.liurq.util.IDCardUtil;
import com.liurq.util.IDUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.IdGenerator;

import java.util.Date;

/**
 * @Author:hyz
 * @Date:2021-02-08
 * @Desc:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;

    /**
     * 1、新建用户信息
     * 2、新建就诊人为用户本人
     *
     * @param req
     * @return
     */
    @Override
    @Transactional
    public RspInfo saveUserInfo(SaveUserInfoReq req) {

        //插入用户信息表
        String sex = IDCardUtil.getSex(req.getUserIdCard());
        Date birth = IDCardUtil.getBirth(req.getUserIdCard());
        Date date = new Date();
        String id = IDUtils.genUUId();
        User user = new User();
        user.setUserId(id);
        user.setUserName(req.getUserName());
        user.setUserSex(sex);
        user.setUserPhone(req.getUserPhone());
        user.setUserAddress(req.getAddress());
        user.setUserIdCard(req.getUserIdCard());
        user.setUserPassword("");
        user.setUserBirthday(birth);
        user.setCreateDate(date);
        user.setUpdateDate(date);
        user.setStatus("0");
        userMapper.insert(user);

        //插入就诊人表
        Patient patient = new Patient();
        patient.setPatientId(IDUtils.genUUId());
        patient.setPatientIdCard(req.getUserIdCard());
        patient.setPatientName(req.getUserName());
        patient.setPatientSex(sex);
        patient.setPatientParentId(id);
        patient.setPatientPhone(req.getUserPhone());
        patient.setPatientAddress(req.getAddress());
        patient.setPatientRelation("0");
        patient.setPatientBirthday(birth);
        patient.setCreateDate(date);
        patient.setUpdateDate(date);
        patient.setStatus("0");
        patientMapper.insert(patient);

        return RspInfo.success("成功");
    }

    /**
     * 跳往主页
     *
     * @param user
     * @return
     */
    @Override
    public RspInfo getUserInfo(UserDetails user) {
        //获取认证用户信息
        String userPhone = user.getUsername();

        //移除redis中的验证码
        personRedisFeignClient.removeAuthCode(userPhone);
        //向redis中存储Token

        //查询数据库
        com.liurq.server.model.User u = userMapper.selectByUserPhone(userPhone);
        if (ObjectUtils.isNotEmpty(u)){
            return RspInfo.success(u);
        }

        return RspInfo.success(null);
    }


}
