package com.liurq.server.controller.hospital;

import com.github.pagehelper.PageInfo;
import com.liurq.server.restful.req.system.hospital.SelectDoctorReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.SelectDoctorRsp;
import com.liurq.server.service.DoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:hyz
 * @Date:2021-02-14
 * @Desc:
 **/
@RestController
@RequestMapping("/server/doctor")
public class DoctorInfoController {

    @Autowired
    private DoctorInfoService doctorInfoService;

    @RequestMapping("/selectDoctorInfo")
    public RspInfo<PageInfo<SelectDoctorRsp>> selectDoctorInfo(SelectDoctorReq req){
        return doctorInfoService.selectDoctor(req);
    }

}
