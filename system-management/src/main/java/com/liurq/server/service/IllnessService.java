package com.liurq.server.service;

import com.liurq.server.model.Illness;
import com.liurq.server.restful.req.hospital.DepartmentIdReq;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-15
 * @Desc:
 **/
public interface IllnessService {


    /**
     * 根据科室查询热门疾病
     * @return
     */
    List<Illness> selectHotIllnessByDepartment(DepartmentIdReq req);

}
