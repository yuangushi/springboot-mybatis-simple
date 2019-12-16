package com.ylp.test.service.impl;

import com.ylp.test.entity.User;
import com.ylp.test.mapper.UserMapper;
import com.ylp.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        List<User> list=userMapper.getAllUser();
        list=removeDulipates(list);
        return list;
//        return userMapper.getAllUser();
    }

    //去除重复的数据,从springboot加载autoConfiguration里学到的
    public <T> List<T> removeDulipates(List<T> list){
        return new ArrayList<>(new LinkedList<>(list));
    }
}
