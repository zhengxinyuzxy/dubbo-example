package com.mellow.dao;

import com.mellow.pojo.OrderSetting;

import java.util.Date;

public interface OrderSettingDao {
    void add(OrderSetting orderSetting);

    long findByOrderDate(Date orderDate);

    void editNumberByOrderDate(OrderSetting orderSetting);
}
