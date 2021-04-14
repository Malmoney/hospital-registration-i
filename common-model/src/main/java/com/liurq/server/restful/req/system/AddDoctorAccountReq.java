package com.liurq.server.restful.req.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

    private String doctorName;
    private String doctorSex;
    private String doctorLevel;

}
