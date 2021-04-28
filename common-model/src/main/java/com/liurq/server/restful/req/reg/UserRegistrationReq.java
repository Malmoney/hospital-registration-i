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
 * @Date:2021-04-24
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class UserRegistrationReq implements Serializable {
    private static final long serialVersionUID = 2777071393496215337L;

    @NotEmpty
    private String visitId;
    @Min(1)
    @Max(50)
    private int num;
    @NotEmpty
    private String patientId;
    @NotEmpty
    private String doctorId;
    @NotEmpty
    private String time;
    @NotEmpty
    private String userId;
}
