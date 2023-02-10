package org.clb.mybatisTest.service.impl;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;
import org.clb.mybatisTest.entity.User;
import org.clb.mybatisTest.mapper.UserMapper;
import org.clb.mybatisTest.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        List<User> users = userMapper.selectAllList();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    @Transactional
    public List<User> userCursor() {
        System.out.println("开始===================="+"当前线程"+Thread.currentThread().getName());
        Cursor<User> users = userMapper.selectUserList(new RowBounds(1,1));
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {

            System.out.println("===>user:"+iterator.next());
        }
        Cursor<User> users2 = userMapper.selectUserList(new RowBounds(2,1));
        Iterator<User> iterator2 = users2.iterator();
        while (iterator2.hasNext()) {

            System.out.println("===>user:"+iterator2.next());
        }
        System.out.println("结束========================================================================");
        return null;
    }
}
