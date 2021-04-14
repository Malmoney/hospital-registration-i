package com.liurq.server.restful.rsp.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-03-31
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class AddHospitalAccountRsp implements Serializable {
    private static final long serialVersionUID = -3711581496144936556L;

    private String userName;
    private String userPassword;
    private String hospitalId;
    private String hospitalName;
    private String hospitalLevel;
    private List<AddHospitalAccountRsp> childs;

}
