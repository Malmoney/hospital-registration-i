package com.liurq.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liurq.server.dao.DoctorMapper;
import com.liurq.server.model.Doctor;
import com.liurq.server.model.DoctorExample;
import com.liurq.server.restful.req.system.hospital.SelectDoctorReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.SelectDoctorRsp;
import com.liurq.server.service.DoctorInfoService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-14
 * @Desc:
 **/
@Service
public class DoctorInfoServiceImpl implements DoctorInfoService {

    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * 根据条件查询医生信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<PageInfo<SelectDoctorRsp>> selectDoctor(@Valid SelectDoctorReq req) {
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<SelectDoctorRsp> result = doctorMapper.selectDoctor(req);
        if (ObjectUtils.isEmpty(result)){
            result = new ArrayList<>();
        }
        PageInfo<SelectDoctorRsp> pageInfo = new PageInfo<>(result);
        return RspInfo.success(pageInfo);
    }
}
