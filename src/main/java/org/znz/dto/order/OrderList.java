package org.znz.dto.order;

import org.znz.entity.Order;

import java.util.List;

/**
 * Created by zhouxin on 17-5-10.
 */
public class OrderList {
    private int pages;

    private List<Order> orderList;

    public OrderList(int pages, List<Order> orderList) {
        this.pages = pages;
        this.orderList = orderList;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
