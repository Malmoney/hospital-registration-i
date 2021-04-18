package com.liurq.server.filter;

import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.util.JsonUtils;
import com.liurq.util.PropertiesUtil;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 * @Author:hyz
 * @Date:2021-04-13
 * @Desc:
 **/
@Aspect
@Component
public class PermissionFilter implements Filter {
    public final static Logger log = LoggerFactory.getLogger(Filter.class);
    private static String[] openUrl;
    private static String[] whiteHost;

    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        openUrl =PropertiesUtil.getString(PropertiesUtil.SHIRO_PATH, "anon").split(",");
        whiteHost =PropertiesUtil.getString(PropertiesUtil.SHIRO_PATH, "whiteHost").split(",");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contentType = req.getHeader("content-type");
//        response.setCharacterEncoding("utf-8");

        //放行静态文件
        String reqUri = req.getRequestURI().trim();
        if (isStaticFile(reqUri) || contentType==null || "".equals(contentType)){
            log.info("放行静态资源："+reqUri);
            chain.doFilter(req,res);
        }else{
            //对请求进行鉴权
            String requestBody="";
            if(contentType.indexOf("application/json")>=0){
                requestBody=HttpHelper.getBodyString((HttpServletRequest) request);
            }else if(contentType.indexOf("application/x-www-form-urlencoded")>=0){
                requestBody = getRequestBody((HttpServletRequest) request);
            }else{
                chain.doFilter(req, res);
                return;
            }

            log.error("请求类型:"+contentType);
            log.error("请求接口:"+req.getRequestURI().trim());
            log.error("请求报文:"+requestBody);
            //String remoteHost = (String)req.getHeader("HTTP_X_FORWARDED_FOR");
            if (isOpenUrl(reqUri) || isWhitHost(req.getRemoteHost())){
                WrapperedRequest wrapRequest = new WrapperedRequest(
                        (HttpServletRequest) req,requestBody);
                WrapperedResponse wrapResponse = new WrapperedResponse(
                        (HttpServletResponse) res);
                chain.doFilter(wrapRequest, wrapResponse);
                byte[] data = wrapResponse.getResponseData();
                String responseBody=new String(data, "utf-8");
                log.info("返回结果:"+responseBody);
                writeResponse(res, responseBody);
            }else{
                //获取token
                String token = req.getHeader("Authorization");
                if (StringUtils.isEmpty(token)){
                    log.info("禁止通行:无认证权限");
                    response.getWriter().write(new String(this.getNoLoginRsp().getBytes(), "utf-8"));
                    return;
                }else{
                    String user = personRedisFeignClient.getUser(token);
                    if (ObjectUtils.isEmpty(user)){
                        log.info("禁止通行:认证已过期");
                        res.getWriter().write(this.getNoLoginRsp());
                        return;
                    }else{
                        WrapperedRequest wrapRequest = new WrapperedRequest(
                                (HttpServletRequest) req,requestBody);
                        WrapperedResponse wrapResponse = new WrapperedResponse(
                                (HttpServletResponse) res);

                        chain.doFilter(wrapRequest, wrapResponse);
                        byte[] data = wrapResponse.getResponseData();
                        String responseBody=new String(data, "utf-8");
                        log.info("返回结果:"+responseBody);
                        writeResponse(res, responseBody);
                    }
                }
            }
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isStaticFile(String reqUri) {
        String lower = reqUri.toLowerCase();
        if(lower.endsWith(".html")
                || lower.endsWith(".htm")
                || lower.endsWith(".js")
                || lower.endsWith(".css")
                || lower.endsWith(".jsp")
                || lower.endsWith(".jpg")
                || lower.endsWith(".jpeg")
                || lower.endsWith(".png")
                || lower.endsWith(".gif")
                || lower.endsWith(".pdf")
                || lower.endsWith(".svg")
        ){
            return true;
        }
        return false;
    }

    private void writeResponse(ServletResponse response, String responseString)
            throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(responseString);
        out.flush();
        out.close();
    }
    /**
     * @param request
     * @return
     */
    private String getRequestBody(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Map map=request.getParameterMap();
        Set set=map.entrySet();
        Map.Entry[] entry=(Map.Entry[])set.toArray(new Map.Entry[0]);
        for(int i=0;i<entry.length;i++)
        {
            sb.append(entry[i].getKey());
            sb.append("=");
            String value[]=(String[])entry[i].getValue();
            for(int j=0;j<value.length;j++)
            {
                sb.append(value[j]);
            }
        }
        return sb.toString();
    }

    public boolean isOpenUrl(String uri) {
        //如果是放行的资源,直接放行
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (String url : openUrl) {
            if (antPathMatcher.match(url, uri)) {
                log.info("放行openUrl："+uri);
                return true;
            }
        }
        return false;
    }

    private String getNoLoginRsp(){
        RspInfo<String> rspInfo = new RspInfo<>();
        rspInfo.setRspData("请登录");
        rspInfo.setRspCode("1001");
        rspInfo.setRspDesc("请登录");
        return rspInfo.toString();
    }

    private boolean isWhitHost(String host){
        for (String h:whiteHost){
            if (host.equals(h)){
                log.info("放行ip白名单："+host);
                return true;
            }
        }
        return false;
    }
}
