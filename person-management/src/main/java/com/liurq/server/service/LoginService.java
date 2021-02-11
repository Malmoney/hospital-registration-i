package com.liurq.server.service;

import com.liurq.server.restful.req.person.LoginReq;
import com.liurq.server.restful.rsp.RspInfo;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 * 登录相关业务
 **/
public interface LoginService {

    /**
     * 获取验证码
     * @param userPhone
     * @return
     */
    RspInfo getNumber(String userPhone);

    /**
     * 跳往主页
     * @param user
     * @return
     */
    RspInfo toMain(UserDetails user);

}
