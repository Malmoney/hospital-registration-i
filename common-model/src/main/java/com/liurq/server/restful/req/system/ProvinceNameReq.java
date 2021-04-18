package com.liurq.server.restful.req.system;

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
public class ProvinceNameReq implements Serializable {
    private static final long serialVersionUID = 4030218250827530145L;

    @NotEmpty
    private String proName;
}
