package com.tina.restaurant.controller;

import com.tina.restaurant.entity.UserInfo;
import com.tina.restaurant.service.impl.UserServiceImpl;
import com.tina.restaurant.vo.JSONResponse;
import com.tina.restaurant.vo.ShareResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
public class UserInfoController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private HttpSession session;

    @PostMapping("user/insert")
    public int insert(@RequestBody UserInfo record) {

        return userService.insert(record);
    }

    @PostMapping("/user/login")
    public JSONResponse userLogin(@RequestBody UserInfo userInfo) {
        JSONResponse jsonResponse = userService.userLogin(userInfo);
        if (jsonResponse.getCode() != 401) {
            session.setAttribute("userInfo", jsonResponse);
            return jsonResponse;
        }
        return jsonResponse;
    }
}
