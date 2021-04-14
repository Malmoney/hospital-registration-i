//package com.liurq.server.handler;
//
//import com.liurq.server.dao.UserMapper;
//import com.liurq.server.feign.PersonRedisFeignClient;
//import com.liurq.server.restful.rsp.RspInfo;
//import com.liurq.util.IDUtils;
//import com.liurq.util.JsonUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.UUID;
//
///**
// * @Author:hyz
// * @Date:2021-02-08
// * @Desc: 自定义登录Handler，已失效
// **/
//@Component
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Autowired
//    private PersonRedisFeignClient personRedisFeignClient;
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse rsp, Authentication a) throws IOException {
//        rsp.setCharacterEncoding("UTF-8");
//        //获取认证用户信息
//        User user = (User) a.getPrincipal();
//        String userPhone = user.getUsername();
//        //移除redis中的验证码
//        personRedisFeignClient.removeAuthCode(userPhone);
//        //向redis中存储Token
//        String token = IDUtils.genUUId();
//        personRedisFeignClient.setUser(user,token);
//        //查询数据库
//        com.liurq.server.model.User u = userMapper.selectByUserPhone(userPhone);
//        if (ObjectUtils.isEmpty(u)){
//            RspInfo<String> rspInfo = new RspInfo<>();
//            rspInfo.setRspData(token);
//            rspInfo.setRspCode("999");
//            rspInfo.setRspDesc("请完善用户信息");
//            rsp.getWriter().write(JsonUtils.objectToJson(rspInfo));
//        }else{
//            rsp.getWriter().write(JsonUtils.objectToJson(RspInfo.success(token)));
//        }
//
//        //rsp.sendRedirect("/server/login/toMain");
//
//    }
//}
