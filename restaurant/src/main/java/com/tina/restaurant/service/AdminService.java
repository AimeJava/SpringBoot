package com.tina.restaurant.service;

import com.tina.restaurant.entity.Admin;

import java.util.List;


public interface AdminService {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);

    Admin verifyLanding(Admin admin);
}
