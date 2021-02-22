package com.liurq.redis.server.service;


import org.springframework.security.core.userdetails.User;

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
    int setAuthCode(String userPhone,String code);

    /**
     * 获取缓存中的用户验证码
     * @param userPhone
     * @return
     */
    String getAuthCode(String userPhone);

    /**
     * 移除验证码
     * @param userPhone
     * @return
     */
    void removeAuthCode(String userPhone);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    User getUser(String token);

    /**
     * 根据token存放用户
     * @param user
     * @param token
     * @return
     */
    void setUser(User user, String token);
}
