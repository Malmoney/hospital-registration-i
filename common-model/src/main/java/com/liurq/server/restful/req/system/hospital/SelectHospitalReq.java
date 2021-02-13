package com.liurq.server.restful.req.system.hospital;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:查询医院请求
 **/
@Data
public class SelectHospitalReq implements Serializable {

    private static final long serialVersionUID = -477853701592442458L;

    private String city;

}
