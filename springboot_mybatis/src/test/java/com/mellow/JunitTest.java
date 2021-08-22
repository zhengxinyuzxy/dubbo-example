package com.mellow;

import com.mellow.pojo.User;
import com.mellow.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public void findAll() {
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
