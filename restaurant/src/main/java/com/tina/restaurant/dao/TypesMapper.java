package com.tina.restaurant.dao;

import com.tina.restaurant.entity.Types;
import java.util.List;

public interface TypesMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Types record);

    Types selectByPrimaryKey(Integer typeId);

    List<Types> selectAll();

    int updateByPrimaryKey(Types record);
}