package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.CustomDao;
import org.znz.dao.GoodDao;
import org.znz.dao.OrderDao;
import org.znz.dao.OrderItemDao;
import org.znz.dto.common.View;
import org.znz.dto.order.OrderDetail;
import org.znz.dto.order.OrderList;
import org.znz.entity.Custom;
import org.znz.entity.Good;
import org.znz.entity.Order;
import org.znz.entity.OrderItem;
import org.znz.service.OrderService;

import java.util.ArrayList;
import java.util.List;

import static org.znz.helper.Validator.*;

/**
 * Created by zhangbin on 17-5-20.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GoodDao goodDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private CustomDao customDao;

    public View createOrderByParams(Order order,
                                    List<Integer> goodIdList,
                                    List<Integer> goodNumberList,
                                    List<Integer> customIdList) {
        try {
            order.setTotalPrice(0f);
            List<OrderItem> itemList = new ArrayList<OrderItem>();
            goodIdList = RemoveAllNull(goodIdList);
            goodNumberList = RemoveAllNull(goodNumberList);
            customIdList = RemoveAllNull(customIdList);
            if(goodIdList.size() != goodNumberList.size() || goodIdList.size() == 0) {
                return new View(false, "参数错误");
            }
            if(goodIdList.size() != customIdList.size()) {
                return new View(false, "参数错误");
            }
            for (int i = 0; i < goodIdList.size(); i++) {
                Good good = goodDao.queryGoodById(goodIdList.get(i));
                if (good == null) {
                    return new View(false, "商品不存在");
                }
                Custom custom = customDao.queryCustomById(customIdList.get(i));
                if (custom == null) {
                    return new View(false, "商品规格不存在");
                }
                if (goodNumberList.get(i) <= 0) {
                    return new View(false, "商品数量有误");
                }
                OrderItem orderItem = new OrderItem();
                orderItem.setGoodId(good.getGoodId());
                orderItem.setGoodName(good.getName());
                orderItem.setPrice(good.getPrice());
                orderItem.setNumber(goodNumberList.get(i));
                orderItem.setCustomId(custom.getCustomId());
                orderItem.setCustomName(custom.getName());
                order.addTotalPrice(good.getPrice() * goodNumberList.get(i));
                itemList.add(orderItem);
            }
            orderDao.createOrderByParams(order);
            for(OrderItem item:itemList) {
                item.setOrderId(order.getOrderId());
                orderItemDao.createOrderItemByParams(item);
            }
            return new View(true, "订单创建成功");

        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View getOrdersByParams(Order order, Integer page, Integer size) {
        if (page <= 0) {
            page = 1;
        }
        if (size<= 0) {
            size = 6;
        }
        int offset = (page -1)*size;
        try {
            List<Order> orderList = orderDao.queryOrdersByParams(order, offset, size);
            int count = orderDao.queryOrdersCountByParams(order);
            int pages = (count + size - 1) / size;
            return new View(new OrderList(pages, orderList));
        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View getOrderById(Integer orderId) {
        try {
            Order order = orderDao.queryOrderById(orderId);
            List<OrderItem> orderItemList = orderItemDao.queryOrderItemsByOrderId(orderId);
            return new View(new OrderDetail(order, orderItemList));
        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View updateOrderByParams(Order order) {
        try {
            int count;
            count = orderDao.updateOrderByParams(order);
            if (count <= 0) {
                return new View(false, "更新失败");
            }
            return new View(true, "更新成功");
        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }
}
