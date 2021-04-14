package com.liurq.server.restful.req.hospital;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-15
 * @Desc:DepartmentIdReq
 **/
@Data
public class DepartmentIdReq implements Serializable {
    private static final long serialVersionUID = -7245752286844906246L;

    @NotEmpty
    private String departmentId;

}
