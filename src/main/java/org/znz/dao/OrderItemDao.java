package org.znz.dao;

import org.znz.entity.OrderItem;

public interface OrderItemDao {
    int createOrderItemByParams(OrderItem orderItem);
}
