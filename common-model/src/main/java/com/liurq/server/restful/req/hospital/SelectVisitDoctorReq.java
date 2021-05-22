package com.liurq.server.restful.req.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-05-22
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class SelectVisitDoctorReq implements Serializable {
    private static final long serialVersionUID = 7625672465657856767L;

    private String departmentId;
    private String hospitalId;

    //分页把控
    @NotNull
    private int pageNum;
    @NotNull
    private int pageSize;
}
