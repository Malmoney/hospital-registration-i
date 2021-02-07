package com.liurq.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author:hyz
 * @Date:2021-02-06
 * @Desc:
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //配置spring security的登录路径以及自定义登录逻辑
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/server/login/userLogin")
                .successForwardUrl("/toMain");//post请求，需要编写控制器跳转页面

        http.authorizeRequests()
                .antMatchers("/login.html","/js/**","/server/login/**").permitAll()
                .anyRequest().authenticated();//

        http.csrf().disable();//关闭csrf防护
    }

    //spring security要求必须指定一个PasswordEncoder
    @Bean
    public PasswordEncoder getPWDEncoder(){
        return new BCryptPasswordEncoder();
    }
}
