package com.liurq.server.controller.hospital;

import com.liurq.server.model.Illness;
import com.liurq.server.restful.req.system.hospital.DepartmentIdReq;
import com.liurq.server.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class IllnessController {

    @Autowired
    private IllnessService illnessService;

    @RequestMapping("/selectHotIllnessByDepartment")
    public List<Illness> selectHotIllnessByDepartment(@Valid DepartmentIdReq req){
        return illnessService.selectHotIllnessByDepartment(req);
    }


}
