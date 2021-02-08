package com.liurq.server.service.impl;

import com.liurq.server.dao.UserMapper;
import com.liurq.server.model.User;
import com.liurq.server.restful.req.person.SaveUserInfoReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 保存用户信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo saveUserInfo(SaveUserInfoReq req) {
        Date date = new Date();

        User user = new User();
        user.setUserId();
        user.setUserName();
        user.setUserSex();
        user.setUserPhone();
        user.setUserImage();
        user.setUserAddress(req.getAddress());
        user.setUserIdCard(req.getUserIdCard());
        user.setUserPassword("");
        user.setUserBirthday();
        user.setCreateDate(date);
        user.setUpdateDate(date);
        user.setStatus("0");

        userMapper.insert()
        return null;
    }
}
