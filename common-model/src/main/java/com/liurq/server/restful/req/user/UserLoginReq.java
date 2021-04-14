package com.liurq.server.restful.req.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-13
 * @Desc:
 **/
@Data
@EqualsAndHashCode
@ToString
public class UserLoginReq implements Serializable{
    @NotEmpty
    private String userPhone;
    @NotEmpty
    private String authCode;
}
