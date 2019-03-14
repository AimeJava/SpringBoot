package com.tina.restaurant.service;

import com.tina.restaurant.entity.MenuInfo;
import com.tina.restaurant.vo.MenuResultVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuInfoService {
    int deleteByPrimaryKey(Integer menuId);

    int insert(MenuInfo record);

    MenuInfo selectByPrimaryKey(Integer menuId);

    MenuResultVO selectAll(int num);

    int updateByPrimaryKey(MenuInfo record);
    //根据类型查
    MenuResultVO<Object> sameType(int id,int num);

    List<MenuInfo> fuzzyQueryMenu(String menuName);
}
