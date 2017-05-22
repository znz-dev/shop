package org.znz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.znz.dto.common.View;
import org.znz.entity.Order;
import org.znz.service.OrderService;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View create(@RequestParam("goodIdList") List<Integer> goodIdList,
                       @RequestParam("goodNumberList") List<Integer> goodNumberList,
                       @RequestParam("optionIdList") List<Integer> optionIdList,
                       @ModelAttribute Order order) {
        return orderService.createOrderByParams(order, goodIdList, goodNumberList, optionIdList);

    }

    @RequestMapping(value = "/orderList", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View index(@ModelAttribute Order order,
                      @RequestParam(value = "page", defaultValue = "1") Integer page,
                      @RequestParam(value = "size", defaultValue = "6") Integer size) {

        return orderService.getOrdersByParams(order, page, size);
    }

}
