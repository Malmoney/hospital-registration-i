package com.liurq.server.restful.rsp.reg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-22
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class VisitListRsp implements Serializable {
    private static final long serialVersionUID = 481900138125262908L;

    private String time;
    private String room;
    private String visitId;
    private List<VisitItem> itemList;
}
