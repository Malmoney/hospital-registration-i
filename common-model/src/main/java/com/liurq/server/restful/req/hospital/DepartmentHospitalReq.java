package com.liurq.server.restful.req.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-17
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class DepartmentHospitalReq implements Serializable {
    private static final long serialVersionUID = -8082637101513710507L;

    @NotEmpty
    private String hospitalId;
    @NotEmpty
    private String departmentId;
}
