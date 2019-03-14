package com.tina.restaurant.dao;

import com.tina.restaurant.entity.Message;
import java.util.List;

public interface MessageMapper {
    int insert(Message record);

    List<Message> selectAll();
}