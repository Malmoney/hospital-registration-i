package com.liurq.server.controller.hospital;

import com.github.pagehelper.PageInfo;
import com.liurq.server.model.Hospital;
import com.liurq.server.restful.req.system.hospital.SelectHospitalReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:
 **/
@RestController
@RequestMapping("/server/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/selectHospital")
    public RspInfo<PageInfo<Hospital>> selectHospital(@Valid SelectHospitalReq req){
        return hospitalService.selectHospital(req);
    }

}
