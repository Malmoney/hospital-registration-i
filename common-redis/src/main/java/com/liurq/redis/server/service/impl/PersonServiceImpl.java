package com.liurq.redis.server.service.impl;

import com.liurq.redis.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${key.redis.person.authcode}")
    private String personAuthcodeKey;
    @Value("${key.redis.person.authToken}")
    private String personAuthTokenKey;
    /**
     * 设置验证码
     *
     * @param userPhone
     * @param code
     * @return
     */
    @Override
    public int setAuthCode(String userPhone, String code) {
        try{
            //过期时间为10分钟
            redisTemplate.opsForValue().set(personAuthcodeKey+userPhone,code,10, TimeUnit.MINUTES);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    /**
     * 获取缓存中的用户验证码
     * @param userPhone
     * @return
     */
    @Override
    public String getAuthCode(String userPhone) {
        return (String)redisTemplate.opsForValue().get(personAuthcodeKey+userPhone);
    }

    /**
     * 移除验证码
     *
     * @param userPhone
     * @return
     */
    @Override
    public void removeAuthCode(String userPhone) {
        redisTemplate.delete(personAuthcodeKey+userPhone);
    }
}
