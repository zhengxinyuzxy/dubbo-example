package com.mellow.controller;

import com.mellow.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaDiscoveryClient eurekaDiscoveryClient;

    /****
     * 服务降级处理方法
     * 当某个方法发生异常或者执行超时的时候，则直接让该方法处理用户的请求
     * @return*/
    public User failBack(Integer id){
        User user = new User();
        user.setUsername("服务降级,默认处理！");
        return  user;
    }

    @RequestMapping("/findById/{id}")
//    @HystrixCommand(fallbackMethod = "failBack")
    public User findByUserId(@PathVariable(value = "id") Integer id) {
        /*List<ServiceInstance> list = eurekaDiscoveryClient.getInstances("user-provider");
        ServiceInstance serviceInstance = list.get(0);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/provider/findById/"+ id;*/
//        String url = "http://localhost:18081/provider/findById/"+id;
        String url = "http://user-provider/provider/findById/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
