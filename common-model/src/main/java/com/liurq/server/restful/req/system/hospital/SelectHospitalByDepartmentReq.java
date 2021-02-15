package com.liurq.server.restful.req.system.hospital;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:查询医院请求
 **/
@Data
public class SelectHospitalByDepartmentReq implements Serializable {

    private static final long serialVersionUID = -477853701592442459L;

    @NotEmpty
    private String city;
    @NotEmpty
    private String departmentId;

    @NotNull
    private int pageNum;
    @NotNull
    private int pageSize;


}
