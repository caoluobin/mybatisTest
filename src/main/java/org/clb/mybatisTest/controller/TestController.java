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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

    @GetMapping("/userCursor")
    public List<User> userCursor() {
        return userService.userCursor();
    }
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    @GetMapping("/t")
    public String t() throws InterruptedException {
        String name = "cc";
        try {
            executorService.submit(()->{
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(name);
                throw new Exception("ssss");
            });
            TimeUnit.SECONDS.sleep(4);
            System.out.println("gggg");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return "ccc";
    }
}
