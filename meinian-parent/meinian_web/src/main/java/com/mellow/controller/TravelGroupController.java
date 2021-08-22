package com.mellow.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mellow.constant.MessageConstant;
import com.mellow.entity.PageResult;
import com.mellow.entity.QueryPageBean;
import com.mellow.entity.Result;
import com.mellow.pojo.TravelGroup;
import com.mellow.pojo.TravelItem;
import com.mellow.service.TravelGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travelgroup")
public class TravelGroupController {

    @Reference
    private TravelGroupService travelGroupService;

    @RequestMapping("/add")
    public Result add(Integer[] travelItemIds, @RequestBody TravelGroup travelGroup) {
        travelGroupService.add(travelItemIds,travelGroup);
        return new Result(true, MessageConstant.ADD_TRAVELGROUP_SUCCESS);
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = travelGroupService.findPage(queryPageBean);
        return pageResult;
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        TravelGroup travelGroup = travelGroupService.findById(id);
        return new Result(true,MessageConstant.QUERY_TRAVELGROUP_SUCCESS,travelGroup);
    }

    @RequestMapping("/findTravelItemIdByTravelgroupId")
    public List<Integer> findTravelItemIdByTravelgroupId(Integer id) {
        List<Integer> lists = travelGroupService.findTravelItemIdByTravelgroupId(id);
        return lists;

    }

}
