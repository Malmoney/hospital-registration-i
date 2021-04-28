package com.liurq.server.restful.req.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author:hyz
 * @Date:2021-04-24
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class PatientIdReq implements Serializable {
    private static final long serialVersionUID = 8023756545713899134L;
    
    @NotEmpty
    private String patientId;
}
