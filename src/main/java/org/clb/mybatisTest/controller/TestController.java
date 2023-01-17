package org.clb.mybatisTest.controller;

import org.clb.mybatisTest.entity.SysOrg;
import org.clb.mybatisTest.service.SysOrgService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    SysOrgService sysOrgService;
    @GetMapping("/aa")
    public List<SysOrg> test() {

        return sysOrgService.list();
    }
}
