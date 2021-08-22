package com.mellow.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mellow.dao.TravelGroupDao;
import com.mellow.entity.PageResult;
import com.mellow.entity.QueryPageBean;
import com.mellow.pojo.TravelGroup;
import com.mellow.pojo.TravelItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = TravelGroupService.class)
@Transactional
public class TravelGroupServiceImpl implements TravelGroupService {

    @Autowired
    private TravelGroupDao travelGroupDao;

    @Override
    public void add(Integer[] travelItemIds, TravelGroup travelGroup) {
        // 添加travelGroup表单
        travelGroupDao.addTravelGroup(travelGroup);
        // 添加中间表
        setTravelGroupAndTravelItem(travelItemIds, travelGroup.getId());
    }

    private void setTravelGroupAndTravelItem(Integer[] travelItemIds, Integer travelGroupId) {
        for (Integer travelItemId : travelItemIds) {
            travelGroupDao.setTravelGroupAndTravelItem(travelItemId, travelGroupId);

        }

    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        // 集合中包含三个参数
        // 执行分页
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        // 执行条件查询
        Page<TravelGroup> page = travelGroupDao.findPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public TravelGroup findById(Integer id) {
        return travelGroupDao.findById(id);
    }

    @Override
    public List<Integer> findTravelItemIdByTravelgroupId(Integer travelgroupId) {
        return travelGroupDao.findTravelItemIdByTravelgroupId(travelgroupId);
    }


}
