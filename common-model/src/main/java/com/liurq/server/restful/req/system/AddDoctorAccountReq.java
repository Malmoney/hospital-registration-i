package com.liurq.server.restful.req.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @Author:hyz
 * @Date:2021-03-29
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class AddDoctorAccountReq extends CommonAccountReq{
    private static final long serialVersionUID = -5256174395304859735L;

    @NotEmpty
    private String doctorName;
    @NotEmpty
    private String doctorSex;
    @NotEmpty
    private String doctorLevel;
    @NotEmpty
    private String departId;
}
