package com.mellow.service;

import com.mellow.pojo.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User findUserById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);
}
