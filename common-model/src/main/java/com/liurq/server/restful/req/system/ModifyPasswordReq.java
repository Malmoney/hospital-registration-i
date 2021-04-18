package com.liurq.server.restful.req.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-03-31
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class ModifyPasswordReq implements Serializable {
    private static final long serialVersionUID = -6579289846481240371L;

    @NotEmpty
    private String memberId;
    private String userName;
    @NotEmpty
    private String password;
    private String oldPassword;
}
