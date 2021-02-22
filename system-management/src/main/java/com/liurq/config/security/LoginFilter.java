package com.liurq.config.security;

import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.util.JsonUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @Author:hyz
 * @Date:2021-02-20
 * @Desc:
 **/
@Component
public class LoginFilter extends OncePerRequestFilter {

    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse rsp, FilterChain filterChain) throws ServletException, IOException {

        //获取token,判断token是否失效
        String token = req.getHeader("Authorization");
        if(!StringUtils.isBlank(token)){
            //查询redis，获取token
            User user =  personRedisFeignClient.getUser(token);
            if (!ObjectUtils.isEmpty(user)){
                UsernamePasswordAuthenticationToken authentication  = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                //设置为已认证
                SecurityContextHolder.getContext().setAuthentication(authentication );
                //放行
                filterChain.doFilter(req,rsp);
            }else{
                filterChain.doFilter(req,rsp);
            }
            //用户登录已过期
            //rsp.sendError(403,"登录信息已过期");
        }else{
            filterChain.doFilter(req,rsp);
        }
    }
}
