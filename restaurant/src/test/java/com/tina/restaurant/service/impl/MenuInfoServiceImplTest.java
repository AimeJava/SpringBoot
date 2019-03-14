package com.tina.restaurant.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tina.restaurant.dao.MenuInfoMapper;
import com.tina.restaurant.entity.MenuInfo;
import com.tina.restaurant.vo.MenuResultVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MenuInfoServiceImplTest {

    @Autowired
    MenuInfoMapper menuInfoMapper;

    @Test
    public void selectByPrimaryKey() {
        MenuInfo menuInfo = menuInfoMapper.selectByPrimaryKey(1);
        System.out.println(menuInfo.getMenuId());
    }

    @Test
    public void selectAll() {
        List<MenuInfo> menuInfos = menuInfoMapper.selectAll();
        System.out.println(menuInfos.size());

    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void sameType() {
        MenuResultVO<List<MenuInfo>> menuResultVO = new MenuResultVO<>();
        PageHelper.startPage(1, 8);
        List<MenuInfo> menuInfos = menuInfoMapper.sameType(1);
        PageInfo<MenuInfo> pageInfo = new PageInfo<>(menuInfos);

        System.out.println(pageInfo.getPageSize());
        System.out.println(pageInfo.getTotal());
//        menuResultVO.setCount(pageInfo.getPageSize()).setData(menuInfos)
//                .setCode(200).setError("没问题");
//        System.out.println(menuResultVO);
    }

    @Test
    public void fuzzyQueryMenu() {
        List<MenuInfo> menuInfos = menuInfoMapper.fuzzyQueryMenu("酱");
        System.out.println(menuInfos.size());
    }
}