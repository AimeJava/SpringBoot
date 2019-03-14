package com.tina.restaurant.service.impl;

import com.tina.restaurant.dao.CartMapper;
import com.tina.restaurant.entity.Cart;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartServiceImplTest {

    @Autowired
    CartMapper cartMapper;

    @Test
    public void selectAll() {
        List<Cart> carts = cartMapper.selectAll(1);
    }
    @Test
    public void same() {

    }
}