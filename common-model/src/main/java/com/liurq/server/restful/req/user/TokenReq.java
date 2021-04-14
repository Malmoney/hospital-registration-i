package com.liurq.server.restful.req.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-13
 * @Desc:
 **/
@Data
public class TokenReq implements Serializable {
    private static final long serialVersionUID = -6119735355022761207L;

    @NotEmpty
    private String token;
}

