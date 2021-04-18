package com.liurq.server.restful.req.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-03-29
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class AddHospitalAccountReq extends CommonAccountReq {
    private static final long serialVersionUID = 3543983360642251364L;

    @NotEmpty
    private String hospitalName;
    @NotEmpty
    private String hospitalLevel;
    //分院
    private List<AddHospitalAccountReq> childs;
}
