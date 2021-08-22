package com.mellow.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mellow.dao.OrderSettingDao;
import com.mellow.pojo.OrderSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {

    @Autowired
    private OrderSettingDao orderSettingDao;

    @Override
    public void add(List<OrderSetting> orderSettings) {

        for (OrderSetting orderSetting : orderSettings) {// 先查询数据库中是否已存在
            long count = orderSettingDao.findByOrderDate(orderSetting.getOrderDate());
            // 判断是否大于0，大于0说明已存在，存在根据日期修改数量，不存在时添加
            if (count > 0) {
                orderSettingDao.editNumberByOrderDate(orderSetting);

            } else {
                orderSettingDao.add(orderSetting);
            }
        }
    }
}
