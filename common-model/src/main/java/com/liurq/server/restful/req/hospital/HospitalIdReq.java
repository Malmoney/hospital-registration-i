package com.liurq.server.restful.req.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-15
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class HospitalIdReq implements Serializable {
    private static final long serialVersionUID = -6448538367678084280L;
    @NotEmpty
    private String hospitalId;
}
