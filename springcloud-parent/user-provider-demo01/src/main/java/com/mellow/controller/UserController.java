package com.mellow.controller;

import com.mellow.pojo.User;
import com.mellow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable(value = "id") Integer id) {
        User user = userService.findByUserId(id);
        user.setName("user-provider-demo01");
        return user;
    }
}
