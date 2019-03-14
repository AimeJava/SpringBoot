package com.tina.restaurant.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tina.restaurant.dao.MenuInfoMapper;
import com.tina.restaurant.entity.MenuInfo;
import com.tina.restaurant.service.MenuInfoService;
import com.tina.restaurant.vo.MenuResultVO;
import com.tina.restaurant.vo.ShareResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    private MenuInfoMapper menuInfoMapper;


    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return 0;
    }

    @Override
    public int insert(MenuInfo record) {
        return 0;
    }

    @Override
    public MenuInfo selectByPrimaryKey(Integer menuId) {
        return menuInfoMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public MenuResultVO<Object> selectAll(int num) {
        MenuResultVO<Object> resultVO = new MenuResultVO();
        //  PageHelper.startPage(num, 8);
        List<MenuInfo> menuInfos = menuInfoMapper.selectAll();
        PageInfo<MenuInfo> pageInfo = new PageInfo<>(menuInfos);

        resultVO.setCount((int) pageInfo.getTotal()).setData(menuInfos).setCode(200).setError("没问题");

        return resultVO;
    }

    public ShareResultVO<Object> adminSelectAll() {
        ShareResultVO<Object> resultVO = new ShareResultVO<>();

        List<MenuInfo> menuInfos = menuInfoMapper.selectAll();
        PageInfo<MenuInfo> pageInfo = new PageInfo<>(menuInfos);

        resultVO.setData(menuInfos).setCode(200).setError("没问题");

        return resultVO;
    }

    @Override
    public int updateByPrimaryKey(MenuInfo record) {
        return 0;
    }

    @Override
    public MenuResultVO<Object> sameType(int id, int num) {
        MenuResultVO<Object> resultVO = new MenuResultVO<>();

        if (num > 1) {
            PageHelper.startPage(num, 8);
            List<MenuInfo> menuInfos = menuInfoMapper.sameType(id);
            PageInfo<MenuInfo> pageInfo = new PageInfo<>(menuInfos);

            resultVO.setCount((int) pageInfo.getTotal()).setData(menuInfos).setCode(200).setError("没问题");

        } else {

            PageHelper.startPage(num, 8);
            List<MenuInfo> menuInfos = menuInfoMapper.sameType(id);
            PageInfo<MenuInfo> pageInfo = new PageInfo<>(menuInfos);

            resultVO.setCount((int) pageInfo.getTotal()).setData(menuInfos).setCode(200).setError("没问题");

        }

        return resultVO;
    }

    public List<MenuInfo> fuzzyQueryMenu(String menuName) {
        return menuInfoMapper.fuzzyQueryMenu(menuName);
    }
}
