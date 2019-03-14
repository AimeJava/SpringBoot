package com.tina.restaurant.dao;

import com.tina.restaurant.entity.UserInfo;
import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo record);

    UserInfo userLogin(UserInfo userInfo);
}