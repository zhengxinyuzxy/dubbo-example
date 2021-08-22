package com.mellow.dao;

import com.github.pagehelper.Page;
import com.mellow.pojo.TravelGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelGroupDao {
    void addTravelGroup(TravelGroup travelGroup);

    void setTravelGroupAndTravelItem(@Param("travelItemId") Integer travelItemId, @Param("travelGroupId") Integer travelGroupId);

    Page<TravelGroup> findPage(String queryString);

    TravelGroup findById(Integer id);

    List<Integer> findTravelItemIdByTravelgroupId(Integer travelgroupId);
}
