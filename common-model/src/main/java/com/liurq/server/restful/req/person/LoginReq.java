package com.liurq.server.restful.req.person;

import com.liurq.server.restful.req.ReqBody;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@ApiModel(description = "登录请求")
public class LoginReq extends ReqBody {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
