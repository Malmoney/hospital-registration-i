package com.liurq.redis.server.controller;

import com.liurq.redis.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

/**
 * @Author:hyz
 * @Date:2021-02-07
 * @Desc:
 **/
@RestController
@RequestMapping(value = "/person/server")
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/setAuthCode")
    public int setAuthCode(@RequestParam @NotEmpty String userPhone, @RequestParam @NotEmpty String code){
        return this.personService.setAuthCode(userPhone,code);
    }

    @RequestMapping("/getAuthCode")
    public String getAuthCode(@RequestParam String userPhone){
        return personService.getAuthCode(userPhone);
    }

    @PostMapping("/removeAuthCode")
    public void removeAuthCode(@RequestParam String userPhone){
        this.personService.removeAuthCode(userPhone);
    }

}
