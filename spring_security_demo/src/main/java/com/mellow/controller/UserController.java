package com.mellow.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("add")
    @PreAuthorize("hasAnyAuthority('add')")
    public String add() {
        return "success";
    }
    // 没有Update的权限，所以不能成功
    @RequestMapping("/update")
    @PreAuthorize("hasAnyAuthority('update')")//表示用户必须拥有ROLE_ADMIN角色才能调用当前方法
    public String update(){
        System.out.println("update...");
        return "success";
    }
    @RequestMapping("/delete")
    @PreAuthorize("hasRole('ABC')")//表示用户必须拥有ABC角色才能调用当前方法
    public String delete(){
        System.out.println("delete...");
        return "success";
    }
}
