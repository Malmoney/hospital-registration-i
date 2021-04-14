package com.liurq.server.controller.hospital;

import com.liurq.server.model.Illness;
import com.liurq.server.restful.req.hospital.DepartmentIdReq;
import com.liurq.server.service.IllnessService;
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
 * @Date:2021-02-15
 * @Desc:
 **/
@RestController
@RequestMapping("/server/illness")
@Api(description = "疾病控制器")
public class IllnessController {

    @Autowired
    private IllnessService illnessService;

    @RequestMapping(value = "/selectHotIllnessByDepartment",method = RequestMethod.POST)
    @ApiOperation(value = "查询科室下的热门疾病",notes = "查询科室下的热门疾病")
    public List<Illness> selectHotIllnessByDepartment(@RequestBody @Valid DepartmentIdReq req){
        return illnessService.selectHotIllnessByDepartment(req);
    }


}
