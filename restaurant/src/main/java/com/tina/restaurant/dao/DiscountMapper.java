package com.tina.restaurant.dao;

import com.tina.restaurant.entity.Discount;
import java.util.List;

public interface DiscountMapper {
    int deleteByPrimaryKey(Integer discountId);

    int insert(Discount record);

    Discount selectByPrimaryKey(Integer discountId);

    List<Discount> selectAll();

    int updateByPrimaryKey(Discount record);
}