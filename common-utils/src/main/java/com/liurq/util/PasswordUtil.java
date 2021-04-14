package com.liurq.util;

import sun.security.provider.MD5;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author:hyz
 * @Date:2021-03-30
 * @Desc:  密码加密工具类
 **/
public class PasswordUtil {

    /**
     * 获得md5加密的密码
     * @param pass
     * @return
     */
    public static String getPassword(String pass){
        String password = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            md5.update(pass.getBytes(StandardCharsets.UTF_8));
            return new BigInteger(1,md5.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }
}
