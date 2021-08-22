package com.mellow.dubbo.handle;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mellow.dubbo.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {

    @Reference
    private HelloService helloService;


    @RequestMapping("/hello")
    public String testController(String name) {

        String oneresult = helloService.sayHello(name);
//        long after = System.currentTimeMillis();
        System.out.println(oneresult);
        return oneresult;


    }
}
