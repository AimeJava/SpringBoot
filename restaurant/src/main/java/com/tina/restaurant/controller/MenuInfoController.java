package com.tina.restaurant.controller;

import com.tina.restaurant.entity.MenuInfo;
import com.tina.restaurant.service.impl.MenuInfoServiceImpl;
import com.tina.restaurant.vo.MenuResultVO;
import com.tina.restaurant.vo.ShareResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuInfoController {

    @Autowired
    private MenuInfoServiceImpl menuInfoService;

    @GetMapping("/menu/getById")
    MenuInfo selectByPrimaryKey(int menuId){
        return menuInfoService.selectByPrimaryKey(menuId);
    }

    @GetMapping("/menu/allMenu")
    MenuResultVO<Object> selectAll(Integer num){
        return menuInfoService.selectAll(num);
    }

    @GetMapping("/menu/all")
    ShareResultVO<Object> adminSelectAll(){
        return menuInfoService.adminSelectAll();
    }

    @GetMapping("/menu/getTypeId")
    public MenuResultVO<Object> sameType(int id,int num) {
        return  menuInfoService.sameType(id, num);
    }

    @GetMapping("/menu/fuzzyQueryMenu")
    public List<MenuInfo> fuzzyQueryMenu(String menuName) {
        return menuInfoService.fuzzyQueryMenu(menuName);
    }
}
