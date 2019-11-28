package com.ylp.test.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.ylp.test.entity.User;
import com.ylp.test.mapper.UserMapper;
import com.ylp.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    @ResponseBody
    public String getUsers(){
        User users=userService.getUserById("1");
        String str= JSON.toJSONString(users);
        return str;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public String getAllUser(){
        List<User> users=userService.getAllUser();
        String str=JSON.toJSONString(users);
        return str;
    }
}
