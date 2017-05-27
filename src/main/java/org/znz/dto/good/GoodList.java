package org.znz.dto.good;

import org.znz.entity.Good;

import java.util.List;


public class GoodList {

    private int pages;

    private List<Good> goodList;

    public GoodList(int pages, List<Good> goodList) {
        this.pages = pages;
        this.goodList = goodList;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }
}
