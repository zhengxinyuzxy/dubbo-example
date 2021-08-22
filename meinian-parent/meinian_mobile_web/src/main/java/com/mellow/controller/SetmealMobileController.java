package com.mellow.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mellow.constant.MessageConstant;
import com.mellow.entity.Result;
import com.mellow.pojo.Setmeal;
import com.mellow.service.SetmealService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setmeal")
public class SetmealMobileController {
    @Reference
    private SetmealService setmealService;

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        Setmeal setmeal = setmealService.findById(id);
        return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS,setmeal);
    }

    @RequestMapping("/getSetmeal")
    public Result findAll() {
        List<Setmeal> lists = setmealService.findAll();
        return new Result(true, MessageConstant.GET_SETMEAL_LIST_SUCCESS,lists);
    }
}
