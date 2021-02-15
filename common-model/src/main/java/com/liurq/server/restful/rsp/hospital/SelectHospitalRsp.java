package com.liurq.server.restful.rsp.hospital;

import com.liurq.server.model.Department;
import com.liurq.server.model.Hospital;
import com.liurq.server.model.HospitalType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-15
 * @Desc:
 **/
@Data
public class SelectHospitalRsp implements Serializable {

    private static final long serialVersionUID = 988486091866756156L;

    private Hospital hospital;

    private HospitalType hospitalType;

    private List<Department> departments;

}
