package com.liurq.server.service;

import com.liurq.server.restful.rsp.RspInfo;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-15
 * @Desc:
 **/
public interface TownShipService {

    /**
     * 查询所有省份
     * @return
     */
    RspInfo<List<String>> selectALlProvince();

    /**
     * 查询所有市
     * @return
     */
    RspInfo<List<String>> selectALlCity();

    /**
     * 查询省分的城市
     * @return
     */
    RspInfo<List<String>> selectCityByProvince(String proName);

}
