package com.mellow.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/springboot")
public class QuickStartController {


    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private String age;


    @RequestMapping("/demo02")
    public String quickDemo02() {
        return "name=" + name + ",age=" + age;
    }

    @RequestMapping("/demo01")
    public String quickDemo01() {
        return "springboot start!";
    }
}
