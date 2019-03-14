package com.tina.restaurant.dao;

import com.tina.restaurant.entity.OrderDetail;
import java.util.List;

public interface OrderDetailMapper {
    int insert(OrderDetail record);

    List<OrderDetail> selectAll();
}