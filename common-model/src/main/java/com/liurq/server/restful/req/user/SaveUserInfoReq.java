package com.liurq.server.restful.req.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-08
 * @Desc:
 **/
@Data
public class SaveUserInfoReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String userName;//姓名
    @NotEmpty
    private String userIdCard;//身份证号
    @NotEmpty
    private String userPhone;//手机号
    @NotEmpty
    private String address;//地址

}
