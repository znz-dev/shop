package org.znz.service;

import org.znz.dto.common.View;
import org.znz.entity.Order;

import java.util.List;

/**
 * Created by zhouxin on 17-5-20.
 */
public interface OrderService {
    View createOrderByParams(Order order,
                             List<Integer> goodIdList, List<Integer> goodNumberList, List<Integer> customIdList);

    View getOrdersByParams(Order order, Integer page, Integer size);

    View getOrderById(Integer orderId);

    View updateOrderByParams(Order order);
}
