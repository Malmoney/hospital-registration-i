//package com.liurq.server.handler;
//
//import com.liurq.server.restful.rsp.RspInfo;
//import com.liurq.util.JsonUtils;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
///**
// * @Author:hyz
// * @Date:2021-02-22
// * @Desc: 权限不足处理
// **/
//@Component
//public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
//        httpServletResponse.setHeader("Content-type", "text/json;charset=UTF-8");
//        httpServletResponse.setStatus(301);
//
//        RspInfo<String> rspInfo = new RspInfo<>();
//        rspInfo.setRspCode("-999");
//        rspInfo.setRspDesc("权限不足");
//
//        httpServletResponse.getWriter().write(JsonUtils.objectToJson(rspInfo));
//    }
//}
