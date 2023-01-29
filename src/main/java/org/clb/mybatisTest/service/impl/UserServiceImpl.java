package org.clb.mybatisTest.service.impl;

import org.clb.mybatisTest.entity.User;
import org.clb.mybatisTest.mapper.UserMapper;
import org.clb.mybatisTest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.selectAllList();
    }
}
