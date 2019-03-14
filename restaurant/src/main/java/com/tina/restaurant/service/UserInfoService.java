package com.tina.restaurant.service;

import com.tina.restaurant.entity.UserInfo;
import com.tina.restaurant.vo.JSONResponse;

import java.util.List;

public interface UserInfoService {

    int insert(UserInfo record);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo record);

    JSONResponse userLogin(UserInfo userInfo);
}
