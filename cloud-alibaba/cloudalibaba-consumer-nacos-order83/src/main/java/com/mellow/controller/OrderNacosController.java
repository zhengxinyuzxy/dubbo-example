package com.mellow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${services-url.nacos-user-service}")
    public String serverURL;

    @RequestMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String url = serverURL+"/payment/nacos/"+id;
        return restTemplate.getForObject(url, String.class);

    }
}
