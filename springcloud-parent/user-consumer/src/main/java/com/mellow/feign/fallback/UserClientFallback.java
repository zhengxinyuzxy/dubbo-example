package com.mellow.feign.fallback;

import com.mellow.feign.UserFeignClient;
import com.mellow.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserFeignClient {
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setUsername("服务熔断");
        return user;
    }
}
