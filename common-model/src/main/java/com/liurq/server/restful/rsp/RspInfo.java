package com.liurq.server.restful.rsp;


import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
public class RspInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String rspCode;
    private String rspDesc;
    private T rspData;

    @Override
    public String toString() {
        return "RspInfo{" +
                "\"rspCode\":\"" + rspCode + '\"' +
                ", \"rspDesc\":\"" + rspDesc + '\"' +
                ", \"rspData\":\"" + rspData +'\"'+
                '}';
    }

    public RspInfo() {
        this.rspCode = RspConstants.SUCCESS;
        this.rspDesc = "success";
    }

    public RspInfo(T rspData) {
        this(RspConstants.SUCCESS, RspConstants.SUCCESS_MESSAGE, rspData);
    }

    public RspInfo(T rspData, String message) {
        this(RspConstants.SUCCESS, message, rspData);
    }

    public RspInfo(String rspCode, T rspData) {
        this(rspCode, RspConstants.SUCCESS_MESSAGE, rspData);
    }

    public RspInfo(String rspCode, String rspDesc, T rspData) {
        this.rspCode = RspConstants.SUCCESS;
        this.rspDesc = "success";
        this.rspCode = rspCode;
        this.rspDesc = rspDesc;
        this.rspData = rspData;
    }

    public T getRspData() {
        return this.rspData;
    }

    public RspInfo<T> setRspData(T rspData) {
        this.rspData = rspData;
        return this;
    }


    public String getRspCode() {
        return this.rspCode;
    }

    public RspInfo<T> setRspCode(String rspCode) {
        this.rspCode = rspCode;
        return this;
    }

    public String getRspDesc() {
        return this.rspDesc;
    }

    public RspInfo<T> setRspDesc(String rspDesc) {
        this.rspDesc = rspDesc;
        return this;
    }

    public static <T> RspInfo<T> success(T data, String message) {
        return new RspInfo(data, message);
    }

    public static <T> RspInfo<T> success(T data) {
        return new RspInfo(data);
    }

    public static <T> RspInfo<T> fail(String message) {
        return fail(message, RspConstants.INTERNAL_ERROR);
    }

    public static <T> RspInfo<T> fail(String code,String message) {
        RspInfo<T> resp = new RspInfo();
        resp.setRspCode(code);
        resp.setRspDesc(message);
        resp.setRspData(null);
        return resp;
    }

    public static <T> RspInfo<T> exception(Throwable e, String message) {
        return exception(e, message, RspConstants.OTHER_ERROR);
    }

    public static <T> RspInfo<T> exception(Throwable e, String message, String statusCode) {
        RspInfo<T> resp = new RspInfo();
        resp.setRspCode(statusCode);
        resp.setRspDesc(message);
        resp.setRspData((T) e.getMessage());
        return resp;
    }
}
