package com.liurq.server.service.impl;

import com.liurq.server.dao.IllnessMapper;
import com.liurq.server.model.Illness;
import com.liurq.server.restful.req.system.hospital.DepartmentIdReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-15
 * @Desc:
 **/
@Service
public class IllnessServiceImpl implements IllnessService {

    @Autowired
    private IllnessMapper illnessMapper;


    /**
     * 根据科室查询热门疾病
     *
     * @param req
     * @return
     */
    @Override
    public List<Illness> selectHotIllnessByDepartment(DepartmentIdReq req) {
        List<Illness> result = this.illnessMapper.selectHotIllnessByDepartment(req.getDepartmentId());
        if (result == null){
            return  new ArrayList<>();
        }

        return result;
    }
}
