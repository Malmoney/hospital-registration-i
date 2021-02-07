package com.liurq.server.restful.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
public abstract class ReqBody implements Serializable {
    private static final long serialVersionUID = 1L;
    protected static final SerializerFeature[] serializerFeatures;

    public ReqBody() {
    }

    public String toString() {
        return JSON.toJSONString(this, serializerFeatures);
    }

    static {
        serializerFeatures = new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat};
    }
}
