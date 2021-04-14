package com.liurq.server.restful.req.hospital;

import com.liurq.server.model.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-12
 * @Desc:
 **/
@Data
@EqualsAndHashCode
@ToString
public class UpdateHospitalDepartmentReq implements Serializable {
    private static final long serialVersionUID = 7250738694881043265L;

    @NotEmpty
    private String hospitalId;
    @NotNull
    private List<Department> departmentList;
}
