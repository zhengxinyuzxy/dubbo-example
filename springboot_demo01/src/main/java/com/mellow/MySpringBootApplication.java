package com.mellow;

import com.mellow.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//声明该类是一个springboot引导类
@SpringBootApplication
public class MySpringBootApplication {
    // main方法是java程序的入口
    public static void main(String[] args) {
        // run方法表示运行springboot的引导类，参数是自己的字节码对象，
        ConfigurableApplicationContext context = SpringApplication.run(MySpringBootApplication.class, args);
        /*String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);*/
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
