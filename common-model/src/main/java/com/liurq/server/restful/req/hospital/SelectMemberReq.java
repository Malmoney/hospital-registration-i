package com.liurq.server.restful.req.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-18
 * @Desc:
 **/
@ToString
@Data
@EqualsAndHashCode
public class SelectMemberReq implements Serializable {
    private static final long serialVersionUID = 3763675727049105531L;
    @NotEmpty
    private String memberId;

    @Min(1)
    @Max(20)
    private int pageSize;
    @Min(1)
    private int pageNum;
}
