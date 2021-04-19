package com.liurq.server.filter;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class HttpHelper {
 
	/**
     * 获取请求Body
     *
     * @param request
     * @return
     */
    public static byte[] getBodyByte(HttpServletRequest request) {
    	return getBodyString(request).getBytes(getCharset(request));
    }
	
    /**
     * 获取请求Body
     *
     * @param request
     * @return
     */
    public static String getBodyString(HttpServletRequest request) {
    	
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, getCharset(request)));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
    
    public static Charset getCharset(HttpServletRequest request){
    	String charset = request.getCharacterEncoding();
    	if(charset == null) {
    		charset = "utf-8";
    	}
    	
    	return Charset.forName(charset);
    }
 
}