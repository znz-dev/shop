package org.znz.dao;

import org.apache.ibatis.annotations.Param;
import org.znz.entity.Order;

import java.util.List;


public interface OrderDao {
    int createOrderByParams(Order order);

    int updateOrderByParams(Order order);

    List<Order> queryOrdersByParams(@Param("order") Order order, @Param("offset") int offset, @Param("limit") int limit);

    int queryOrdersCountByParams(@Param("order") Order order);
}
