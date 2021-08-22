package com.mellow.controller;

import com.mellow.feign.UserFeignClient;
import com.mellow.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class ConsumerFeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("/{id}")
    public User queryById(@PathVariable(value = "id") Integer id) {
        return userFeignClient.findById(id);
    }
}
