package com.mellow.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mellow.dubbo.service.HelloService;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = HelloService.class)
@Transactional
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello--8085--" + name;
    }
}
