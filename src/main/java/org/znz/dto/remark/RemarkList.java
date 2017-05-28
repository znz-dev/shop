package org.znz.dto.remark;

import org.znz.entity.Remark;

import java.util.List;

public class RemarkList {
    private int pages;

    private List<Remark> remarkList;

    public RemarkList(int pages, List<Remark> remarkList) {
        this.pages = pages;
        this.remarkList = remarkList;
    }

    public int getPages() {

        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Remark> getRemarkList() {
        return remarkList;
    }

    public void setRemarkList(List<Remark> remarkList) {
        this.remarkList = remarkList;
    }
}
