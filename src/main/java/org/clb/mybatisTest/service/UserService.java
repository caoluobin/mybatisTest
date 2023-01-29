package org.clb.mybatisTest.service;

import org.clb.mybatisTest.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();


    void insertUser(User user);
}
