package com.ylp.test.mapper;

import com.ylp.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    User getUserById(String id);

    List<User> getAllUser();
}
