package com.liurq.server.restful.rsp.reg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-22
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class VisitItem implements Serializable {
    private static final long serialVersionUID = -5377397433682688939L;

    private String num;
    private String time;
}
