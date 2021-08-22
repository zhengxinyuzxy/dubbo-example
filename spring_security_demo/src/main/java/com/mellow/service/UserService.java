package com.mellow.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserService implements UserDetailsService {

    // 模拟数据库登录
    static Map<String, com.mellow.pojo.User> map =  new HashMap<String , com.mellow.pojo.User>();
    static {
        // 定义数据库中的两个值
        com.mellow.pojo.User user1 = new com.mellow.pojo.User();
        user1.setUsername("zheng");
        user1.setPassword("$2a$10$b7xQ.fiHt4T.0kQww6.Re.AN2LYvvcolwxm.sLI34rob8BnOZsjza");
        user1.setTelephone("155");
        com.mellow.pojo.User user2 = new com.mellow.pojo.User();
        user2.setUsername("zhao");
        user2.setPassword("zhao");
        user2.setTelephone("166");
        map.put(user1.getUsername(),user1);
        map.put(user2.getUsername(),user2);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 拿到数据库的值
        com.mellow.pojo.User user = map.get(s);
        if (user == null) {
            return null;
        }
//        String password = "{noop}" + user.getPassword();
        String password = user.getPassword();
        // 第三个参数是一个集合，声明一个集合来放放入的参数
        List<SimpleGrantedAuthority> objects = new ArrayList<>();
        // 把需要的参数添加进去
        objects.add(new SimpleGrantedAuthority("add"));
        objects.add(new SimpleGrantedAuthority("ABC"));
        objects.add(new SimpleGrantedAuthority("update"));
        objects.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        // 不能返回接口类型，选择接口的实现类，实现类需要三个参数
        return new User(user.getUsername(),password,objects);
    }
}
