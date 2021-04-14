//package com.liurq.config.security;
//
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//import org.springframework.util.StringUtils;
//
///**
// * @Author:hyz
// * @Date:2021-03-13
// * @Desc:
// **/
//@Component
//public class MyRealm extends AuthorizingRealm {
//
//    @Autowired
//    private AdminMapper adminMapper;
//
//    /**
//     * 授权
//     * @param principalCollection
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        return null;
//    }
//
//    /**
//     * 认证
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String username = token.getUsername();
//        if (StringUtils.isEmpty(username)){
//            throw  new AccountException("用户名无效");
//        }
//        Admin user = adminMapper.getByUserName(username);
//        if (ObjectUtils.isEmpty(user)){
//            throw  new AccountException("登录失败，用户名或密码不正确");
//        }
//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,user.getPassword(),"myRealm");
//        return simpleAuthenticationInfo;
//    }
//}
