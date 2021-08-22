package com.mellow.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mellow.constant.MessageConstant;
import com.mellow.entity.PageResult;
import com.mellow.entity.QueryPageBean;
import com.mellow.entity.Result;
import com.mellow.pojo.TravelItem;
import com.mellow.service.TravelItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travelItem")
public class TravelItemController {
    @Reference
    private TravelItemService travelItemService;


    @RequestMapping("/findAll")
    public Result findAll() {
        List<TravelItem> lists = travelItemService.findAll();
        return new Result(true,MessageConstant.QUERY_TRAVELGROUP_SUCCESS,lists);
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody TravelItem travelItem) {
        travelItemService.edit(travelItem);
        return new Result(true,MessageConstant.EDIT_TRAVELITEM_SUCCESS);
    }


    @RequestMapping("/findById")
    public Result findById(Integer id){
        TravelItem travelItem = travelItemService.findById(id);
        return new Result(true,MessageConstant.QUERY_TRAVELITEM_SUCCESS,travelItem);
    }

    @RequestMapping("/delete")
    public Result deleteById(Integer id) {
        try {
            travelItemService.deleteById(id);
            return new Result(true,MessageConstant.DELETE_TRAVELITEM_SUCCESS);
        }catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_TRAVELITEM_FAIL);
        }
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = travelItemService.findPage(queryPageBean);
        return pageResult;

    }

    @RequestMapping("/add")
    public Result add(@RequestBody TravelItem travelItem) {
      travelItemService.add(travelItem);
      return new Result(true, MessageConstant.ADD_TRAVELITEM_SUCCESS);
    }


}
