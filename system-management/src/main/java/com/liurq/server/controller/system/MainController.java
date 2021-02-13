package com.liurq.server.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:hyz
 * @Date:2021-02-11
 * @Desc:跳往主页的controller
 **/
@Controller
public class MainController {

    @RequestMapping("/server/login/toMain")
    public String toMain(){
        return "redirect:/main.html";
    }

}
