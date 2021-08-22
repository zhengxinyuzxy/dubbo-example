package com.mellow.dao;

import com.mellow.pojo.Setmeal;

import java.util.List;

public interface SetmealDao {
    List<Setmeal> findAll();

    Setmeal findById(Integer id);
}
