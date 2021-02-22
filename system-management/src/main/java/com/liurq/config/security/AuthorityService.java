package com.liurq.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:hyz
 * @Date:2021-02-22
 * @Desc:
 **/
@Component("myauthorityservice")
public class AuthorityService {
    @Value("${security.openUrl}")
    private String[] openUrl;

    public boolean hasPermission(HttpServletRequest req, Authentication a) {

        Object principal =  a.getPrincipal();
        if (!ObjectUtils.isEmpty(principal) && !"anonymousUser".equals(principal)) {
            //进行权限验证
            return true;
        }
        //如果是放行的资源,直接放行
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        String uri = req.getRequestURI();
        for (String url : openUrl) {
            if (antPathMatcher.match(url, uri)) {
                return true;
            }
        }
        return false;
    }
}
