package com.tina.restaurant.service.impl;

import com.tina.restaurant.dao.UserInfoMapper;
import com.tina.restaurant.entity.UserInfo;
import com.tina.restaurant.service.UserInfoService;
import com.tina.restaurant.vo.Constants;
import com.tina.restaurant.vo.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int insert(UserInfo record) {

        return userInfoMapper.insert(record);

    }

    @Override
    public List<UserInfo> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return 0;
    }

    @Override
    public JSONResponse userLogin(UserInfo userInfo) {
        UserInfo user = userInfoMapper.userLogin(userInfo);

        if (user != null) {
            return JSONResponse.OK(Constants.SUCCESS_200, user);
        } else {
            return JSONResponse.ERROR(Constants.ERROR_401, "手机号或密码错误");
        }
    }
}
