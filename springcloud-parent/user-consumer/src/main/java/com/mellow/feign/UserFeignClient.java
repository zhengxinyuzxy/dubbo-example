package com.mellow.feign;

import com.mellow.feign.fallback.UserClientFallback;
import com.mellow.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-provider",fallback = UserClientFallback.class)
public interface UserFeignClient {

    @RequestMapping("/provider/findById/{id}")
    User findById(@PathVariable(value = "id") Integer id);
}
