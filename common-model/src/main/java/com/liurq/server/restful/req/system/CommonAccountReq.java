package com.liurq.server.restful.req.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-03-29
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class CommonAccountReq implements Serializable {
    private static final long serialVersionUID = 2416117262207480926L;

    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    private String type;
    private String parentId;//账号的管理者的id

}
