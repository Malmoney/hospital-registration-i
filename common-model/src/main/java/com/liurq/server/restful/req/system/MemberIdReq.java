package com.liurq.server.restful.req.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-18
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class MemberIdReq implements Serializable {
    private static final long serialVersionUID = 2620916069858094924L;

    @NotEmpty
    private String memberId;
}
