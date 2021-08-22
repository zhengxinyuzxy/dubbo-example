package com.mellow.service.Impl;

import com.mellow.dao.UserDao;
import com.mellow.pojo.User;
import com.mellow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }
}
