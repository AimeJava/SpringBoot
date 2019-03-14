package com.tina.restaurant.dao;

import com.tina.restaurant.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {

    List<Cart> selectAll(Integer userId);

}