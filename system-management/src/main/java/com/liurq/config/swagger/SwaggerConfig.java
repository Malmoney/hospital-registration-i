package com.liurq.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author:hyz
 * @Date:2021-04-06
 * @Desc:
 **/
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestServerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("系统管理平台","系统管理平台","1.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liurq.server.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("系统管理");
    }


    private ApiInfo apiInfo(String name, String description, String version) {
        return new ApiInfoBuilder()
                .title(name)
                .description(description)
                .termsOfServiceUrl("")
                //.contact(contact)
                .version(version)
                .build();
    }
}
