package com.tina.restaurant.service.impl;


import com.tina.restaurant.dao.AdminMapper;
import com.tina.restaurant.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
@SpringBootTest
// 让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
@RunWith(SpringRunner.class)
public class AdminServiceImplTest {

    @Autowired
    AdminServiceImpl adminService;

    @Autowired
    AdminMapper adminMapper;

    @Test
    public void adminAll() {
        List<Admin> admins = adminMapper.selectAll();
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void verifyLanding() {
        Admin admin = new Admin();
        admin.setAdminName("admin");
        admin.setAdminPwd("admin1");
        Admin admin1 = adminMapper.verificationAdmin(admin);

    }
}