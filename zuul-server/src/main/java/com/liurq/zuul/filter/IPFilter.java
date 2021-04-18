package com.liurq.zuul.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:hyz
 * @Date:2021-04-15
 * @Desc:
 **/
public class IPFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse rsp = (HttpServletResponse)servletResponse;
        req.setAttribute("remoteHost",req.getRemoteHost());
        rsp.addHeader("remoteHost",req.getRemoteHost());
        filterChain.doFilter(req,rsp);
    }

    @Override
    public void destroy() {

    }
}
