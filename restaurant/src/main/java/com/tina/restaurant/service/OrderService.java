package com.tina.restaurant.service;

import com.tina.restaurant.entity.OrderInfo;

import java.util.List;

public interface OrderService {

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer orderId);

    List<OrderInfo> realTimeOrder();
    List<OrderInfo> historyOrder();
    int updateByPrimaryKey(OrderInfo record);
}
