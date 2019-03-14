package com.tina.restaurant.controller;

import com.tina.restaurant.dao.OrderInfoMapper;
import com.tina.restaurant.entity.OrderInfo;
import com.tina.restaurant.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;


    @GetMapping("/order")
    public List<OrderInfo> realTimeOrder() {
        List<OrderInfo> orderInfos = orderService.realTimeOrder();
        return orderInfos;
    }
    @GetMapping("/historyOrder")
    public List<OrderInfo> historyOrder() {
        List<OrderInfo> orderInfos = orderService.historyOrder();
        return orderInfos;
    }

}
