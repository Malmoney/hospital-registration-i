package com.liurq.server.service.impl;

import com.liurq.server.dao.TownShipMapper;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.TownShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-15
 * @Desc:
 **/
@Service
public class TownShipServiceImpl implements TownShipService {

    @Autowired
    private TownShipMapper townShipMapper;


    /**
     * 查询所有省份
     *
     * @return
     */
    @Override
    public RspInfo<List<String>> selectALlProvince() {
        return RspInfo.success(townShipMapper.selectAllProvince());
    }

    /**
     * 查询所有市
     *
     * @return
     */
    @Override
    public RspInfo<List<String>> selectALlCity() {
        return RspInfo.success(townShipMapper.selectAllCity());
    }

    /**
     * 查询省分的城市
     *
     * @param proName
     * @return
     */
    @Override
    public RspInfo<List<String>> selectCityByProvince(String proName) {
        return RspInfo.success(townShipMapper.selectCityByProvince(proName));
    }
}
