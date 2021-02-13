package com.liurq.server.service;

import com.liurq.server.restful.rsp.RspInfo;

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



}
