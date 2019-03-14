package com.tina.restaurant.service.impl;

import com.tina.restaurant.dao.MenuInfoMapper;
import com.tina.restaurant.dao.UserInfoMapper;
import com.tina.restaurant.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {


    @Autowired
    UserInfoMapper userInfoMapper;


    @Test
    public void userLogin() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserTel("13059349680");
        userInfo.setUserPwd("123456");
        UserInfo userInfo1 = userInfoMapper.userLogin(userInfo);;
    }
}