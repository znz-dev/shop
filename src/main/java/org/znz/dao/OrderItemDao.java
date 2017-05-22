package org.znz.dao;

import org.znz.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {
    int createOrderItemByParams(OrderItem orderItem);

    List<OrderItem> queryOrderItemsByOrderId(Integer orderId);
}
