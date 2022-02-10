package com.xuncai.utils;

import java.io.Serializable;

public class Entity implements Serializable {
    //页码数，默认为1
    private Integer page = 1;
    //页面大小。默认为10
    private Integer limit = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
