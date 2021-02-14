package com.liurq.server.restful.rsp.hospital;

import com.liurq.server.model.Department;
import com.liurq.server.model.Doctor;
import com.liurq.server.model.Hospital;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-14
 * @Desc:查询医生信息
 **/
@Data
public class SelectDoctorRsp implements Serializable {

    private static final long serialVersionUID = -4843048754875420244L;

    private Doctor doctor;          //医生
    private Department department;  //科室
    private Hospital hospital;      //医院


}
