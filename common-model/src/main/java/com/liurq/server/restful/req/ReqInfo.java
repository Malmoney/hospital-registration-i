package com.liurq.server.restful.req;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javafx.scene.control.Pagination;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/

@ApiModel(
        description = "通用请求报文信息"
)
public class ReqInfo<H extends ReqHead, B extends ReqBody> implements Serializable {
    private static final long serialVersionUID = 1L;
    protected static final SerializerFeature[] serializerFeatures;
    @ApiModelProperty(
            value = "请求头",
            required = true,
            position = 10
    )
    @Valid
    @NotNull(
            message = "reqHead节点不能为空"
    )
    private H reqHead;
    @ApiModelProperty(
            value = "请求体",
            required = true,
            position = 20
    )
    @Valid
    @NotNull(
            message = "reqBody节点不能为空"
    )
    private B reqBody;

    public ReqInfo() {
    }

    public H getReqHead() {
        return this.reqHead;
    }

    public void setReqHead(H reqHead) {
        this.reqHead = reqHead;
    }

    public B getReqBody() {
        return this.reqBody;
    }

    public void setReqBody(B reqBody) {
        this.reqBody = reqBody;
    }

    public String toString() {
        return JSON.toJSONString(this, serializerFeatures);
    }

    static {
        serializerFeatures = new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat};
    }
}
