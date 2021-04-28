package com.liurq.server.restful.req.reg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-25
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class VisitIdReq implements Serializable {
    private static final long serialVersionUID = -1628378348743159389L;

    @NotEmpty
    private String visitId;
}
