package com.liurq.server.handler;

import com.liurq.server.restful.rsp.RspInfo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:hyz
 * @Date:2021-02-22
 * @Desc: 未登录处理
 **/
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendError(-888,"未登录");
        //httpServletResponse.getWriter().write(RspInfo.success("301","未登录").toString());
    }
}
