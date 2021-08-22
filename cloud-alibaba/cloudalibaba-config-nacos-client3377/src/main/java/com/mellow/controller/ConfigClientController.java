package com.mellow.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

    public void githubTest() {
        System.out.println("github commit 01");
        System.out.println("gitee commit 01");
        System.out.println("github commit 02");
        System.out.println("github commit 03");
        System.out.println("gitee commit 02");
    }

}
