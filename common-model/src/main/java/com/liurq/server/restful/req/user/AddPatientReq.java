package com.liurq.server.restful.req.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class AddPatientReq implements Serializable {
    private static final long serialVersionUID = -7134508479470024025L;

    @NotEmpty
    private String userId;
    @NotEmpty
    private String idCard;
    @NotEmpty
    private String name;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    @NotEmpty
    private String relation;
}
