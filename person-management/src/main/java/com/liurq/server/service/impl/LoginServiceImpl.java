package com.liurq.server.service.impl;

import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.restful.req.person.LoginReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Random;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@Service
public class LoginServiceImpl implements LoginService, UserDetailsService {


    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;

    /**
     * 获取验证码
     *
     * @param username
     * @return
     */
    @Override
    public RspInfo getNumber(String username) {

        Random random = new Random();
        int num = random.nextInt(8999)+1000;
        int i = personRedisFeignClient.setAuthCode(username,num+"");
        if (i<=0){
            return RspInfo.fail("获取失败，请重试");
        }
        return RspInfo.success(num);
    }

    /**
     * 用户登录逻辑
     * @param req
     * @return
     */
    @Override
    public RspInfo toMain(LoginReq req) {
        String username = req.getUsername();
        String password = req.getPassword();
        String authCode = personRedisFeignClient.getAuthCode(username);

        if (StringUtils.isEmpty(authCode)||!password.equals(authCode)){
            return RspInfo.fail("验证码错误或已失效");
        }

        return RspInfo.success("");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new User(username,"",null);
    }
}
