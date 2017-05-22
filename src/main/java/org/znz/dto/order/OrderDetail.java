package org.znz.dto.order;

import org.znz.entity.Order;
import org.znz.entity.OrderItem;

import java.util.List;

/**
 * Created by zhouxin on 17-5-10.
 */
public class OrderDetail {
    private Order order;

    private List<OrderItem> orderItemList;

    public OrderDetail(Order order, List<OrderItem> orderItemList) {
        this.order = order;
        this.orderItemList = orderItemList;
    }

    public Order getOrder() {

        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
