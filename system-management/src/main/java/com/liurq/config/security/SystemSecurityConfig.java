package com.liurq.config.security;

import com.liurq.server.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author:hyz
 * @Date:2021-02-06
 * @Desc:
 **/
@Configuration
@Order(90)
public class SystemSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LoginFilter loginFilter;

    //配置spring security的登录路径以及自定义登录逻辑
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .usernameParameter("userPhone")
                .passwordParameter("authCode")
                .loginPage("/login.html")
                .loginProcessingUrl("/server/login/userLogin")
                //.successForwardUrl("/server/login/toMain");//post请求，需要编写控制器跳转页面
                .successHandler(loginSuccessHandler);

        http.authorizeRequests()
                .antMatchers("/login.html","/js/**","/server/login/getNumber","/login").permitAll()
                .anyRequest().authenticated();//

        http.addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable();//关闭csrf防护
    }

    //spring security要求必须指定一个PasswordEncoder
    @Bean
    public PasswordEncoder getPWDEncoder(){
        return new BCryptPasswordEncoder();
    }
}
