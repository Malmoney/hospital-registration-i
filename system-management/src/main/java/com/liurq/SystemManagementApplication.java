package com.liurq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = "com.liurq.server.dao")
public class SystemManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemManagementApplication.class,args);
    }
}
