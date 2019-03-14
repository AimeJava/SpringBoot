package com.tina.restaurant.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tina.restaurant.entity.Types;
import com.tina.restaurant.service.impl.TypesServiceImpl;
import com.tina.restaurant.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypesController {
    @Autowired
    private TypesServiceImpl typesService;

    @GetMapping("/type/allTypes")
    public List<Types> selectAll() {
        List<Types> types = typesService.selectAll();
        return types;
    }
}
