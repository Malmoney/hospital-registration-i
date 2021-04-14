package com.liurq.server.restful.req.hospital;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-02-26
 * @Desc:
 **/
@Data
public class DoctorVisitReq implements Serializable {

    @NotEmpty
    private String doctorId;

}
