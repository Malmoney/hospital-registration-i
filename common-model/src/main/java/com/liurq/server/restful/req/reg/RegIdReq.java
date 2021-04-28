package com.liurq.server.restful.req.reg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class RegIdReq implements Serializable {
    private static final long serialVersionUID = 7315296353680364478L;

    @NotEmpty
    private String regId;
}
