package com.mellow.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mellow.constant.MessageConstant;
import com.mellow.entity.Result;
import com.mellow.pojo.OrderSetting;
import com.mellow.service.OrderSettingService;
import com.mellow.utils.POIUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ordersetting")
public class OrderSettingController {

    @Reference
    private OrderSettingService orderSettingService;

    @RequestMapping("/upload")
    public Result upload(MultipartFile excelFile) {
        // 读取excel表格的文件
        try {
            List<String[]> lists = POIUtils.readExcel(excelFile);
            List<OrderSetting> orderSettings = new ArrayList<>();
            for (String[] list : lists) {
                orderSettings.add(new OrderSetting(new Date(list[0]), Integer.parseInt(list[1])));
            }
            orderSettingService.add(orderSettings);
            return new Result(true, MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.IMPORT_ORDERSETTING_FAIL);
        }
    }
}
