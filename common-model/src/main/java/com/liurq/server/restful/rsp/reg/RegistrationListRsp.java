package com.liurq.server.restful.rsp.reg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class RegistrationListRsp implements Serializable {
    private static final long serialVersionUID = 6947255892758221766L;

    private String regId;
    private String doctorName;
    private String num;
    private String time;
    private String nowNum;
    private String doctorImg;
//    private String departName;
    private String room;
    //0-未开始，1-过号，2-已结束
    private String status;
    private String remark;

}
