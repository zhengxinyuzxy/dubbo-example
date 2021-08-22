package com.mellow.entity;

import java.io.Serializable;

public class QueryPageBean implements Serializable {
    private String queryString;//查询条件
    private Integer currentPage;//页码
    private Integer pageSize;//每页记录数


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
}
