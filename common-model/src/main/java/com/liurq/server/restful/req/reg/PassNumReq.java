package com.liurq.server.restful.req.reg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-25
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class PassNumReq implements Serializable {
    private static final long serialVersionUID = 550191226203717998L;
    private String reason;
    @Min(0)
    @Max(50)
    private int num;
    private String nextRegId;
    private String nowRegId;
    @NotEmpty
    private String visitId;
}
