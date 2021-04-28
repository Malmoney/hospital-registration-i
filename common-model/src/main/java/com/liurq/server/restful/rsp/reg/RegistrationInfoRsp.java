package com.liurq.server.restful.rsp.reg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-25
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class RegistrationInfoRsp implements Serializable {
    private static final long serialVersionUID = 6324447267409963430L;

    private String nextRegId;
    private String nowRegId;
    private int nextNum;
    private int nowNum;
    private String visitId;
}
