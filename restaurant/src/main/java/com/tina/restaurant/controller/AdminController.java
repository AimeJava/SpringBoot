package com.tina.restaurant.controller;

import com.tina.restaurant.entity.Admin;
import com.tina.restaurant.service.impl.AdminServiceImpl;
import com.tina.restaurant.vo.Constants;
import com.tina.restaurant.vo.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private HttpSession session;

    @GetMapping(value = "/admin")
    public JSONResponse getAdmin() {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            return JSONResponse.OK(Constants.SUCCESS_200);
        } else {
            return JSONResponse.ERROR(Constants.ERROR_401);
        }

    }

    @DeleteMapping(value = "/admin")
    public JSONResponse removeAdmin() {
        if (session.getAttribute("admin") != null)
            session.invalidate();
        return JSONResponse.OK(Constants.SUCCESS_200);
    }

    @PostMapping(value = "/validation")
    public JSONResponse validationLogin(@RequestBody Admin admin) {
        Admin adminInfo = adminService.verifyLanding(admin);
        if (adminInfo == null) {
            return JSONResponse.ERROR(Constants.ERROR_400, "用户名或密码错误");
        } else {
            session.setAttribute("admin", adminInfo);
            return JSONResponse.OK(Constants.SUCCESS_200, session.getId());
        }


    }

}