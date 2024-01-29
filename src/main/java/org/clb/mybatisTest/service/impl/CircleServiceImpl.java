package org.clb.mybatisTest.service.impl;

import org.clb.mybatisTest.service.CircleService;
import org.clb.mybatisTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircleServiceImpl implements CircleService {

    @Autowired
    private UserService userService;

    @Override
    public void aopTest() {

    }
}
