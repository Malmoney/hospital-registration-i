package com.liurq.redis.server.service.impl;

import com.liurq.redis.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    /**
     * 设置验证码
     *
     * @param username
     * @param code
     * @return
     */
    @Override
    public int setAuthCode(String username, String code) {
        try{
            //过期时间为10分钟
            redisTemplate.opsForValue().set(username,code,10, TimeUnit.MINUTES);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    /**
     * 获取缓存中的用户验证码
     * @param username
     * @return
     */
    @Override
    public String getAuthCode(String username) {
        return (String)redisTemplate.opsForValue().get(username);
    }
}
