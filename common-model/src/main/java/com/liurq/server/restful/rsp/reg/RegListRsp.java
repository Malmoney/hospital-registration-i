package com.liurq.server.restful.rsp.reg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-28
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class RegListRsp implements Serializable {
    private static final long serialVersionUID = -2118878193157584519L;

    private List<VisitItem> nums;
}
