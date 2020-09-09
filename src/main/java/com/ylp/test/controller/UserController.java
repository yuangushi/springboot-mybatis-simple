package com.ylp.test.controller;

import com.alibaba.fastjson.JSON;
import com.ylp.test.annotations.MyTestBean;
import com.ylp.test.conf.MyProperties;
import com.ylp.test.entity.User;
import com.ylp.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MyProperties myProperties;

    @Resource
    private MyTestBean myTestBean;

    @RequestMapping("/getUsers")
    @ResponseBody
    public String getUsers(Class<? extends Number> o){
        User users=userService.getUserById("1");
        String str= JSON.toJSONString(users);
        System.out.println(myProperties);
        System.out.println(myTestBean);
        return str;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public String getAllUser(){
        List<User> users=userService.getAllUser();
        String str=JSON.toJSONString(users);
//        this.getUsers(new Integer(1));
        return str;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insertUser(User u){
        userService.insertUser(u);
        return "返回结果";
    }
}
