//package com.liurq.config.security;
//
//import com.liurq.util.PropertiesUtil;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.session.mgt.SessionManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author:hyz
// * @Date:2021-03-13
// * @Desc:
// **/
//@Configuration
//public class ShiroConfig {
//
//
//    @Bean(name = "myShiroRealm")
//    public MyRealm getMyRealm(){
//       return new MyRealm();
//    }
//    @Bean("securityManager")
//    public DefaultWebSecurityManager securityManager(@Qualifier("myShiroRealm") MyRealm myShiroRealm){
//        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
//        //设置realm.
//        securityManager.setRealm(myShiroRealm);
//        return securityManager;
//    }
//
//    @Bean
//    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//    @Bean
//    public SessionManager sessionManager() {
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        return sessionManager;
//    }
//    @Bean
//    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
//        aasa.setSecurityManager(securityManager);
//        return new AuthorizationAttributeSourceAdvisor();
//    }
//
//    @Bean
//    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
//        daap.setProxyTargetClass(true);
//        return daap;
//    }
//
//
//    //权限管理，配置主要是Realm的管理认证
//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(getMyRealm());
//        return securityManager;
//    }
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        Map<String, String> map = new HashMap<>();
//        String[] annos = PropertiesUtil.getString(PropertiesUtil.SHIRO_PATH, "anon").split(",");
//        for (String v : annos ){
//            map.put(v,"anon");
//        }
//        //登出
//       // map.put("/logout", "logout");
//        //对所有用户认证
////        map.put("/**", "authc");
//        map.put("/**", "anon");
//        //登录
//        shiroFilterFactoryBean.setLoginUrl("/loginHandle");
//        //首页
//        //错误页面，认证不通过跳转
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorizedHandle");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
//        return shiroFilterFactoryBean;
//    }
//    /**
//     * 使用Header进行传输
//     * @return
//     */
////    @Bean
////    public HttpSessionIdResolver httpSessionStrategy() {
////        return new HeaderCookieHttpSessionIdResolver();
////    }
//
//
//}
