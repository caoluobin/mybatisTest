package org.clb.mybatisTest.mapper;

import org.clb.mybatisTest.entity.SysOrg;
import org.clb.mybatisTest.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAllList();

    void insertUser(User user);
}
