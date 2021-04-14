package com.liurq.server.restful.req.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-12
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class MajorDepartmentReq implements Serializable {
    private static final long serialVersionUID = 996814296052187375L;

    @NotEmpty
    private String hospitalId;
    @NotEmpty
    private String departmentId;
}
