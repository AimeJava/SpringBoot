package com.tina.restaurant.service.impl;

import com.tina.restaurant.dao.AdminMapper;
import com.tina.restaurant.entity.Admin;
import com.tina.restaurant.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer adminId) {
        return 0;
    }

    @Override
    public int insert(Admin record) {

        return adminMapper.insert(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public List<Admin> selectAll() {
        List<Admin> admins = adminMapper.selectAll();
        return admins;
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        int insert = adminMapper.insert(record);
        return insert;
    }


    @Override
    public Admin verifyLanding(Admin adminInfo) {
        Admin admin = adminMapper.verificationAdmin(adminInfo);
        return admin;
    }

}
