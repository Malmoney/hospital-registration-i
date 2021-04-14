//package com.liurq.config.security;
//
//import com.liurq.server.handler.AjaxAccessDeniedHandler;
//import com.liurq.server.handler.AjaxAuthenticationEntryPoint;
//import com.liurq.server.handler.LoginSuccessHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * @Author:hyz
// * @Date:2021-02-06
// * @Desc:
// **/
////@Configuration
////@Order(90)
//public class SystemSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private LoginSuccessHandler loginSuccessHandler;
//
//    @Autowired
//    private AjaxAccessDeniedHandler accessDeniedHandler;
//    @Autowired
//    private AjaxAuthenticationEntryPoint authenticationEntryPoint;
//    @Autowired
//    private LoginFilter loginFilter;
//    @Value("${security.openUrl}")
//    private String[] openUrl;
//
//    //配置spring security的登录路径以及自定义登录逻辑
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http//.anonymous().disable()//禁用匿名用户
//                .formLogin()
//                .usernameParameter("userPhone")
//                .passwordParameter("authCode")
//                .loginPage("/login.html")
//                .loginProcessingUrl("/server/login/userLogin")
//                //post请求，需要编写控制器跳转页面
//                //.successForwardUrl("/server/login/toMain");
//                .successHandler(loginSuccessHandler);
//
//        http.authorizeRequests()
//                //.antMatchers(openUrl).permitAll()
//                .anyRequest().access("@myauthorityservice.hasPermission(request,authentication)")
//
//                .and()
//                .httpBasic().authenticationEntryPoint(authenticationEntryPoint);//未登录
//        //权限不足
//        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//        http.addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class);
//
//        http.csrf().disable();//关闭csrf防护
//    }
//
//    //spring security要求必须指定一个PasswordEncoder
//    @Bean
//    public PasswordEncoder getPWDEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
