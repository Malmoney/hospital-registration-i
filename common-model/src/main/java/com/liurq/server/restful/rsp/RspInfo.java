package com.liurq.server.restful.rsp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.logging.log4j.ThreadContext;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@ApiModel(
        description = "通用返回报文信息"
)
public class RspInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "日志标识",
            required = true,
            position = 5
    )
    private String rspLogId;
    @ApiModelProperty(
            value = "返回代码",
            required = true,
            position = 10
    )
    private String rspCode;
    @ApiModelProperty(
            value = "返回备注",
            position = 20
    )
    private String rspDesc;
    @ApiModelProperty(
            value = "返回内容",
            position = 30
    )
    private T rspData;


    public RspInfo() {
        this.rspLogId=ThreadContext.get("logId");
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
        this.rspLogId=ThreadContext.get("logId");
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

    public String getRspLogId() {
        return this.rspLogId;
    }

    public RspInfo<T> setRspLogId(String rspLogId) {
        this.rspLogId = rspLogId;
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
