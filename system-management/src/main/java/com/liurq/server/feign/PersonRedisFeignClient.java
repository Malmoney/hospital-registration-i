package com.liurq.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotEmpty;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@FeignClient(value = "common-redis")
public interface PersonRedisFeignClient {


    //设置验证码
    @PostMapping("/redis/person/server/setAuthCode")
    int setAuthCode(@RequestParam("userPhone") String userPhone, @RequestParam("code") String code);

    //获取缓存中的验证码
    @PostMapping("/redis/person/server/getAuthCode")
    String getAuthCode(@RequestParam("userPhone") String userPhone);

    @PostMapping("/redis/person/server/getAuthCode")
    void removeAuthCode(@RequestParam("userPhone") String userPhone);

}
