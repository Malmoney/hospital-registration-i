package com.liurq.server.restful.req.reg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author:hyz
 * @Date:2021-04-20
 * @Desc:
 **/
@Data
@EqualsAndHashCode
public class AddVisitReq implements Serializable {
    private static final long serialVersionUID = 470786337354663783L;
    protected static SerializerFeature[] serializerFeatures;

    @Override
    public String toString() {
        return JSON.toJSONString(this, serializerFeatures);
    }

    static {
        serializerFeatures = new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat};
    }
    @NotEmpty
    private String doctorId;
    @NotEmpty
    private String room;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
            ,timezone="GMT+8"
    )
    private Date startTime;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
            ,timezone="GMT+8"
    )
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private String departId;
}
