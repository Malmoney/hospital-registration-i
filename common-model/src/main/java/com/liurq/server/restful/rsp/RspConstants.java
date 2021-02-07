package com.liurq.server.restful.rsp;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
public interface RspConstants {

    String SUCCESS = "0000";
    String SUCCESS_MESSAGE = "success";
    String INTERNAL_ERROR = "1";//内部异常
    String INTERNAL_ERROR_MESSAGE = "operation failed";
    String OTHER_ERROR = "2";//运行异常
    String OTHER_ERROR_MESSAGE = "system error";
    String VALID_ERROR = "3";//校验异常
}
