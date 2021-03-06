package com.liurq.server.restful.req.hospital;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:查询医院请求
 **/
@Data
public class SelectDoctorReq implements Serializable {

    private static final long serialVersionUID = -477853701592442458L;

    private String doctorName;
    private String departmentId;
    private String city;
    private String doctorId;
    private String hospitalId;

    //分页把控
    @NotNull
    private int pageNum;
    @NotNull
    private int pageSize;
}
