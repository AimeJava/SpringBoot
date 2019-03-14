package com.tina.restaurant.service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.tina.restaurant.dao.OrderInfoMapper;
import com.tina.restaurant.entity.OrderInfo;
import com.tina.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        return 0;
    }

    @Override
    public int insert(OrderInfo record) {
        return 0;
    }

    @Override
    public OrderInfo selectByPrimaryKey(Integer orderId) {
        return null;
    }

    @Override
    public List<OrderInfo> realTimeOrder() {
        return orderInfoMapper.realTimeOrder();
    }

    @Override
    public List<OrderInfo> historyOrder() {
        return orderInfoMapper.historyOrder();
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return 0;
    }
}
