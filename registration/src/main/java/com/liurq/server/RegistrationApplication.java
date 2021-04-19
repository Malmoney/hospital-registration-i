package com.liurq.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author:hyz
 * @Date:2021-04-19
 * @Desc:
 **/
@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = "com.liurq.server.dao")
public class RegistrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class,args);
    }
}
