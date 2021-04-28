package com.liurq.server.restful.rsp.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-18
 * @Desc:
 **/
@Data
@EqualsAndHashCode
@ToString
public class DoctorMemberInfoRsp implements Serializable {
    private static final long serialVersionUID = -6897662713845620914L;

    private String userName;
    private String doctorName;
    private String departName;
    private String departId;
    private String memberId;
    private String status;
}
