package com.liurq.server.service;

import com.liurq.server.model.User;
import com.liurq.server.restful.req.user.SaveUserInfoReq;
import com.liurq.server.restful.rsp.RspInfo;

/**
 * @Author:hyz
 * @Date:2021-02-08
 * @Desc:
 **/
public interface UserService {


    /**
     * 保存用户信息
     * @return
     */
    RspInfo saveUserInfo(SaveUserInfoReq req);

    /**
     * 跳往主页
     * @param userPhone
     * @return
     */
    User getUserInfo(String userPhone);

}
