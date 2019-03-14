package com.tina.restaurant.controller;

import com.tina.restaurant.service.impl.CartServiceImpl;
import com.tina.restaurant.vo.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CartController {

    @Autowired
    CartServiceImpl cartService;

    @GetMapping(value = "/cart")
    public JSONResponse carts(int userId) {
        return cartService.selectAll(userId);

    }
}
