package com.liurq.server.restful.req.person;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-08
 * @Desc:
 **/
@Data
@ApiModel(description = "保存用户信息请求")
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
