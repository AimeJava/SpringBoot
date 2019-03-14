package com.tina.restaurant.service.impl;

import com.tina.restaurant.dao.OrderInfoMapper;
import com.tina.restaurant.entity.OrderInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Test
    public void selectAll() {
        List<OrderInfo> orderInfos = orderInfoMapper.realTimeOrder();
        System.out.println(orderInfos);
    }
}