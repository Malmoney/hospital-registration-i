package com.liurq.server.restful.req.hospital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-03-18
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class DoctorIdReq implements Serializable {
    private static final long serialVersionUID = -6405779558525178793L;

    @NotEmpty
    private String doctorId;
}
