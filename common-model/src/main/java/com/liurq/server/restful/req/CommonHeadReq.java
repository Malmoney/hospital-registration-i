package com.liurq.server.restful.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@ApiModel(
        description = "公共请求参数"
)
@Data
public class CommonHeadReq extends ReqHead {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "时间戳",
            position = -100
    )
    private Long timestap;

    @ApiModelProperty(
            value = "来源系统,1001后台管理，1002前台展示",
            position = -50
    )
    private String fromSystem;

    @ApiModelProperty(
            value = "用户名",
            position = -10
    )
    private String userName;

    public CommonHeadReq() {
    }
}
