package org.clb.mybatisTest.controller;

import org.clb.mybatisTest.entity.SysOrg;
import org.clb.mybatisTest.entity.User;
import org.clb.mybatisTest.service.SysOrgService;
import org.clb.mybatisTest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    SysOrgService sysOrgService;
    @Resource
    UserService userService;
    @GetMapping("/aa")
    public List<SysOrg> test() {

        return sysOrgService.list();
    }
    @GetMapping("/user")
    public List<User> user() {
        return userService.list();
    }

    @PostMapping("/insertUser")
    public String insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return "插入成功";
    }
}
