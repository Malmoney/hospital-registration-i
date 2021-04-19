package com.liurq.server.restful.rsp.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-03-18
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class DoctorInfoRsp implements Serializable {

    private String image;
    private String level;
    private String department;
    private String remark;
    private String hospital;
    private String workAge;
    private String doctorId;
    private String doctorName;
    private String regCount;
    private String feedbackRate;
    private String phone;
    private String sex;
}
