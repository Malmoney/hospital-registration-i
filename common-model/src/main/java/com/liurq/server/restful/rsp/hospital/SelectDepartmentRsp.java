package com.liurq.server.restful.rsp.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:hyz
 * @Date:2021-04-17
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class SelectDepartmentRsp implements Serializable {
    private static final long serialVersionUID = -6584474787384240629L;

    private String departmentId;
    private String departmentName;
    private String status;
    private String isMajor;

}
