package com.liurq.config;

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
 * @Date:2021-04-19
 * @Desc:
 **/
@Configuration
public class RegSwaggerConfig {

    @Bean
    public Docket createRestServerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("挂号API","挂号API","1.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liurq.server.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("挂号API");
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
