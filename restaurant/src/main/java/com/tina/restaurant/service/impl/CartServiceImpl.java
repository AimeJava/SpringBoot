package com.tina.restaurant.service.impl;

import com.tina.restaurant.dao.CartMapper;
import com.tina.restaurant.entity.Cart;
import com.tina.restaurant.service.CartService;
import com.tina.restaurant.vo.Constants;
import com.tina.restaurant.vo.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public int deleteByPrimaryKey(Integer cartId) {
        return 0;
    }

    @Override
    public int insert(Cart record) {
        return 0;
    }

    @Override
    public Cart selectByPrimaryKey(Integer cartId) {
        return null;
    }

    @Override
    public JSONResponse selectAll(Integer userId) {
        List<Cart> carts = cartMapper.selectAll(userId);
        if (carts != null) {
            JSONResponse.OK(Constants.SUCCESS_200, carts);
        }
        return JSONResponse.ERROR(Constants.ERROR_401);
    }

    @Override
    public int updateByPrimaryKey(Cart record) {
        return 0;
    }
}
