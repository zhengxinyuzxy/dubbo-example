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

        if (id == 3) {
            throw new RuntimeException("aaa");
        }
        // 测试基于feign的hystrix熔断，注释此线程休眠
        /*try {
            System.out.println("正在休眠，ribbon中的负载均衡");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        User user = userService.findByUserId(id);
        user.setName("user-provider");
        return user;
    }
}
