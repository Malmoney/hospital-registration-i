package com.liurq.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liurq.server.dao.HospitalMapper;
import com.liurq.server.model.Hospital;
import com.liurq.server.model.HospitalExample;
import com.liurq.server.restful.req.system.hospital.SelectHospitalReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.HospitalService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:
 **/
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalMapper hospitalMapper;


    /**
     * 根据条件查询医院信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<PageInfo<Hospital>> selectHospital(SelectHospitalReq req) {
        String city = req.getCity();
        String hospitalName = req.getHospitalName();
        HospitalExample example = new HospitalExample();
        HospitalExample.Criteria criteria = example.createCriteria();
        //根据城市
        if(!StringUtils.isEmpty(city)){
            criteria.andHospitalCityEqualTo(city);
        }
        //根据名称
        if(!StringUtils.isEmpty(hospitalName)){
            criteria.andHospitalNameLike(hospitalName);
        }
        criteria.andParentIdEqualTo("0");
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Hospital> result = hospitalMapper.selectByExample(example);
        if (ObjectUtils.isEmpty(result)){
            result = new ArrayList<>();
        }
        PageInfo<Hospital> pageInfo = new PageInfo<>(result);
        return RspInfo.success(pageInfo);
    }
}
