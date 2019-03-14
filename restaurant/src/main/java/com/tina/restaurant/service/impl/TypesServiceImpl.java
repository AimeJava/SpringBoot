package com.tina.restaurant.service.impl;

import com.github.pagehelper.PageHelper;
import com.tina.restaurant.dao.MenuInfoMapper;
import com.tina.restaurant.dao.TypesMapper;
import com.tina.restaurant.entity.Types;
import com.tina.restaurant.service.TypesService;
import com.tina.restaurant.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {

    @Autowired
    private TypesMapper typesMapper;

    @Override
    public List<Types> selectAll() {
        return typesMapper.selectAll();
    }


}
