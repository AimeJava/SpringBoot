package com.tina.restaurant.dao;

import com.tina.restaurant.entity.Admin;
import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);

    Admin verificationAdmin (Admin admin);
}