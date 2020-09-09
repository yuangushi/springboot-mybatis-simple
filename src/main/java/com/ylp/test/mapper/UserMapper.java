package com.ylp.test.mapper;

import com.ylp.test.entity.User;

import java.util.List;
public interface UserMapper {

    User getUserById(String id);

    List<User> getAllUser();

    int insertUser( User user);
}
