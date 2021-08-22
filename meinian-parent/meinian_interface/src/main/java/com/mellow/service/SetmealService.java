package com.mellow.service;

import com.mellow.pojo.Setmeal;

import java.util.List;

public interface SetmealService {
    List<Setmeal> findAll();

    Setmeal findById(Integer id);

}
