package com.liurq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:hyz
 * @Date:2021-02-11
 * @Desc:根据身份证号获取生日和性别
 **/
public class IDCardUtil {

    /**
     * 获取性别
     * @param idCard
     * @return
     */
    public static String getSex(String idCard){
        String sex="";
        if (idCard.length()==18){
            sex = idCard.charAt(16)+"";
            return (Integer.parseInt(sex) % 2 == 0)?"女":"男";
        }
        return "";
    }

    /**
     * 获取生日
     * @param idCard
     * @return
     */
    public static Date getBirth(String idCard){
        String birth = idCard.substring(6, 14);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date birthDate = null;
        try {
            birthDate = df.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return birthDate;
    }

}
