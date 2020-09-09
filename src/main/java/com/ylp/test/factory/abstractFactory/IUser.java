package com.ylp.test.factory.abstractFactory;

import com.ylp.test.entity.User;

public interface IUser {
    public void insert(User user);
    public User getUser(int id);

}
