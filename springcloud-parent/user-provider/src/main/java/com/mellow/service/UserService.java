package com.mellow.service;

import com.mellow.pojo.User;

public interface UserService {
    User findByUserId(Integer id);
}
