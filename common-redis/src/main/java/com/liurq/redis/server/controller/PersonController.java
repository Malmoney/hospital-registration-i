package com.liurq.redis.server.controller;

import com.liurq.redis.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public int setAuthCode(@RequestParam @NotEmpty String username, @RequestParam @NotEmpty String code){
        return this.personService.setAuthCode(username,code);
    }

    @GetMapping("/redis/person/server/getAuthCode")
    String getAuthCode(@RequestParam String username){
        return personService.getAuthCode(username);
    }


}
