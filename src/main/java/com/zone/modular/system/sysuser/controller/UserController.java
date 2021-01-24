package com.zone.modular.system.sysuser.controller;


import com.zone.modular.system.sysuser.entity.User;
import com.zone.modular.system.sysuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ZoneWonderful
 * @since 2020-05-01
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserList")
    public Object getUserList() {
        List<User> userList = userService.getUserList();
        return userList;
    }
}

