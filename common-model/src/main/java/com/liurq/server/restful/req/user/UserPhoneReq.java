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
public class UserPhoneReq implements Serializable {
    private static final long serialVersionUID = 3785976069869803854L;

    @NotEmpty
    private String userPhone;
}
