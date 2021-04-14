package com.liurq.util;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author:hyz
 * @Date:2021-03-13
 * @Desc:
 **/
public class PropertiesUtil {
    public final static String SHIRO_PATH="security/security-shiro.properties";
    public static String getString(String filePath,String key){
        Properties prop = null;
        String value = null;
        try {
            // 通过Spring中的PropertiesLoaderUtils工具类进行获取
            prop = PropertiesLoaderUtils.loadAllProperties(filePath);
            // 根据关键字查询相应的值
            value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
