package com.liurq.server.restful.rsp.reg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-28
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class DoctorVisitRsp implements Serializable {
    private static final long serialVersionUID = 7395527658810623464L;

    private String date;
    private String time;
    private String room;
    private String visitId;
}
