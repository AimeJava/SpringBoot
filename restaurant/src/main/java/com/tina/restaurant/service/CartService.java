package com.tina.restaurant.service;

import com.tina.restaurant.entity.Cart;
import com.tina.restaurant.vo.JSONResponse;

public interface CartService {
    int deleteByPrimaryKey(Integer cartId);

    int insert(Cart record);

    Cart selectByPrimaryKey(Integer cartId);

    JSONResponse selectAll(Integer userId);

    int updateByPrimaryKey(Cart record);
}
