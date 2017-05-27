package org.znz.dto.favor;

import org.znz.entity.Favor;

import java.util.List;

/**
 * Created by zhangbin on 17-5-20.
 */
public class FavorList {
    private List<Favor> favorList;

    private int pages;

    public FavorList(List<Favor> favorList, int pages) {
        this.favorList = favorList;
        this.pages = pages;
    }

    public List<Favor> getFavorList() {

        return favorList;
    }

    public void setFavorList(List<Favor> favorList) {
        this.favorList = favorList;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
