package com.mellow.service;

import com.mellow.entity.PageResult;
import com.mellow.entity.QueryPageBean;
import com.mellow.pojo.TravelGroup;
import com.mellow.pojo.TravelItem;

import java.util.List;

public interface TravelGroupService {
    void add(Integer[] travelItemIds, TravelGroup travelGroup);

    PageResult findPage(QueryPageBean queryPageBean);


    TravelGroup findById(Integer id);

    List<Integer> findTravelItemIdByTravelgroupId(Integer travelgroupId);
}
