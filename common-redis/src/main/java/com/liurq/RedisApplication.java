package com.liurq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class,args);
    }
}
