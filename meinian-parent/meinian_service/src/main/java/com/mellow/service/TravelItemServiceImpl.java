package com.mellow.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mellow.dao.TravelItemDao;
import com.mellow.entity.PageResult;
import com.mellow.entity.QueryPageBean;
import com.mellow.pojo.TravelItem;
import org.apache.poi.hssf.record.DVALRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass=TravelItemService.class)
@Transactional
public class TravelItemServiceImpl implements TravelItemService{
    @Autowired
    private TravelItemDao travelItemDao;

    @Override
    public void add(TravelItem travelItem) {
        travelItemDao.add(travelItem);
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<TravelItem> page = travelItemDao.findPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        long sCount = selectCountById(id);
        if (sCount>0){
            throw new RuntimeException("不能删除级联数据");
        }
        travelItemDao.deleteById(id);
    }

    @Override
    public long selectCountById(Integer id) {
        return travelItemDao.selectCountById(id);
    }

    @Override
    public TravelItem findById(Integer id) {
        return travelItemDao.findById(id);
    }

    @Override
    public void edit(TravelItem travelItem) {
        travelItemDao.edit(travelItem);
    }

    @Override
    public List<TravelItem> findAll() {
        return travelItemDao.findAll();
    }
}
