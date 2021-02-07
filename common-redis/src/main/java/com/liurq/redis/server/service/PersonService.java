package com.liurq.redis.server.service;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
public interface PersonService {


    /**
     * 设置验证码
     * @return
     */
    int setAuthCode(String username,String code);

    /**
     * 获取缓存中的用户验证码
     * @param username
     * @return
     */
    String getAuthCode(String username);
}
