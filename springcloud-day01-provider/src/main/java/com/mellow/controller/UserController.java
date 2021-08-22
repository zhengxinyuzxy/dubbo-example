package com.mellow.controller;

import com.mellow.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("findAll")
    public List<User> findAll() {

        List<User> users = new ArrayList<>();
        users.add(new User("王五", "深圳", 28));
        users.add(new User("李四", "北京", 23));
        users.add(new User("赵六", "上海", 26));
        return users;
    }
}
