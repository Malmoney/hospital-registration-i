package com.liurq.server.restful.req.hospital;

import com.liurq.server.model.Illness;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-01
 * @Desc:
 **/
@Data
@ToString
@EqualsAndHashCode
public class ModifyDoctorInfoReq implements Serializable {
    private static final long serialVersionUID = 3023228994018002251L;

    @NotEmpty
    private String doctorId;
    @NotEmpty
    private String doctorSex;
    @NotEmpty
    private int doctorWorkAge;
    @NotEmpty
    private String doctorImage;
    @NotEmpty
    private String remark;
    @NotEmpty
    private String doctorPhone;
    private List<Illness> major;

}
