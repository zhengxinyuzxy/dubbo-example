package com.mellow.service.impl;

import com.mellow.dao.UserDao;
import com.mellow.pojo.User;
import com.mellow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有
     *
     * @return
     */

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


    /**
     * 根据id查询
     *
     * @return
     */
    @Override
    public User findUserById(Long id) {
        return userDao.findById(id).get();
    }

    /**
     * 保存
     *
     * @return
     */
    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    /**
     * 更新
     *
     * @return
     */
    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    /**
     * 根据id删除
     *
     * @return
     */
    @Override
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }
}
