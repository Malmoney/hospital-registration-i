package com.liurq.server.restful.rsp.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-22
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class AccountInfoRsp implements Serializable {
    private static final long serialVersionUID = 1501488878360772591L;

    private String memberId;
    private String userName;
    private String status;
}
