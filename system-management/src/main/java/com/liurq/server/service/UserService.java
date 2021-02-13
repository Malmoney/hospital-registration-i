package com.liurq.server.service;

import com.liurq.server.restful.req.system.user.SaveUserInfoReq;
import com.liurq.server.restful.rsp.RspInfo;
import org.springframework.security.core.userdetails.UserDetails;

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
     * @param user
     * @return
     */
    RspInfo getUserInfo(UserDetails user);

}
