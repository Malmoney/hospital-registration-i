package com.liurq.config.security;

import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.util.JsonUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    @Value("${security.openUrl}")
    private String[] openUrl;
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse rsp, FilterChain filterChain) throws ServletException, IOException {

        //如果不是放行的资源,则进行token验证
        String token = req.getHeader("Authorization");
        if(!StringUtils.isBlank(token)){
            //查询redis，获取token
            Map userMap =  (Map)personRedisFeignClient.getUser(token);
            if (!ObjectUtils.isEmpty(userMap)){
                ArrayList<Map> authorities = (ArrayList<Map>)userMap.get("authorities");
                String str = "";
                for (Map map : authorities){
                    str +=  map.get("authority")+",";
                }
                User user = new User(
                        (String)userMap.get("username"),
                        "null",
                        (boolean)userMap.get("enabled"),
                        (boolean)userMap.get("accountNonExpired"),
                        (boolean)userMap.get("credentialsNonExpired"),
                        (boolean)userMap.get("accountNonLocked"),
                        AuthorityUtils.commaSeparatedStringToAuthorityList(str)
                );
                UsernamePasswordAuthenticationToken authentication  = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }else{
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        filterChain.doFilter(req,rsp);
    }
}
