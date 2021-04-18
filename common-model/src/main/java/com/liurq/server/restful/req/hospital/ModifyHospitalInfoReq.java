package com.liurq.server.restful.req.hospital;

import com.liurq.server.model.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-03-21
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class ModifyHospitalInfoReq implements Serializable {
    private static final long serialVersionUID = 2035237930435867312L;

    @NotEmpty
    private String hospitalId;
    @NotEmpty
    private String address;
    @NotEmpty
    private String province;
    @NotEmpty
    private String city;
    @NotEmpty
    private String image;
    private String longitude;
    private String latitude;
    @NotEmpty
    private String hospitalLevel;
    @NotEmpty
    private String remark;
    @NotEmpty
    private String hospitalPhone;
    private List<Department> departmentList;
}
