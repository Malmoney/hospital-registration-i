package com.liurq.server.controller.system;

import com.liurq.server.restful.req.system.AddAdminAccountReq;
import com.liurq.server.restful.req.system.ProvinceNameReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.service.TownShipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-04-15
 * @Desc:
 **/
@RestController
@RequestMapping("/server/town")
@Api(description = "城市列表")
public class TownShipController {

    @Autowired
    private TownShipService townShipService;

    /**
     * 查询所有省份
     * @return
     */
    @ApiOperation(value = "查询所有省份",notes = "查询所有省份")
    @RequestMapping(value = "/selectALlProvince",method = RequestMethod.POST)
    public RspInfo<List<String>> selectALlProvince(){
        return townShipService.selectALlProvince();
    }

    /**
     * 查询所有城市
     * @return
     */
    @ApiOperation(value = "查询所有城市",notes = "查询所有城市")
    @RequestMapping(value = "/selectALlCity",method = RequestMethod.POST)
    public RspInfo<List<String>> selectALlCity(){
        return townShipService.selectALlCity();
    }

    /**
     * 查询省份下的城市
     * @return
     */
    @ApiOperation(value = "查询省份下的城市",notes = "查询省份下的城市")
    @RequestMapping(value = "/selectCityByProvince",method = RequestMethod.POST)
    public RspInfo<List<String>> selectCityByProvince(@RequestBody @Valid ProvinceNameReq req){
        return townShipService.selectCityByProvince(req.getProName());
    }

}
