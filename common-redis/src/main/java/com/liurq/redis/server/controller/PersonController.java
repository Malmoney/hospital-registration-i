package com.liurq.redis.server.controller;

import com.liurq.redis.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    @PostMapping("/getUser")
    public User getUser(@RequestParam String token){
        return this.personService.getUser(token);
    }

    /**
     * 根据token存储用户信息
     * @param user
     * @param token
     */
    @PostMapping("/setUser")
    public void setUser(@RequestBody User user, @RequestParam String token){
         this.personService.setUser(user,token);
    }

}
