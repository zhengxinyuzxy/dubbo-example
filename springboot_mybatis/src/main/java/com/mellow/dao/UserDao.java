package com.mellow.dao;

import com.mellow.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    List<User> findAll();

}
