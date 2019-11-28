package com.ylp.test.service;

import com.ylp.test.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(String id);

    List<User> getAllUser();
}
