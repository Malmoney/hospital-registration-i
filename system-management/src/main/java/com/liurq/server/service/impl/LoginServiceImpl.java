package com.liurq.server.service.impl;

import com.liurq.server.dao.UserMapper;
import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@Service
public class LoginServiceImpl implements LoginService,UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取验证码
     *
     * @param userPhone
     * @return
     */
    @Override
    public RspInfo getNumber(String userPhone) {
        if (StringUtils.isBlank(userPhone)){
            return RspInfo.fail("手机号不可为空");
        }
        Random random = new Random();
        int num = random.nextInt(8999)+1000;
        int i = personRedisFeignClient.setAuthCode(userPhone,num+"");
        if (i<=0){
            return RspInfo.fail("获取失败，请重试");
        }
        return RspInfo.success(num);
    }


    @Override
    public UserDetails loadUserByUsername(String userPhone) throws UsernameNotFoundException {
        String authCode = personRedisFeignClient.getAuthCode(userPhone);
        if (StringUtils.isBlank(authCode)){
            throw new UsernameNotFoundException("验证码错误或已失效");
        }
        String pwd = passwordEncoder.encode(authCode);

        return new User(userPhone,pwd,AuthorityUtils.commaSeparatedStringToAuthorityList(""));
    }

}
