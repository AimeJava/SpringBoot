package com.tina.restaurant.dao;

import com.tina.restaurant.entity.MenuInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuInfoMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(MenuInfo record);

    MenuInfo selectByPrimaryKey(Integer menuId);

    List<MenuInfo> selectAll();

    int updateByPrimaryKey(MenuInfo record);

    List<MenuInfo> sameType(@Param("menuId") int id);

    List<MenuInfo> fuzzyQueryMenu(@Param("menuName") String menuName);
}