package org.clb.mybatisTest.service.impl;

import org.clb.mybatisTest.entity.SysOrg;
import org.clb.mybatisTest.mapper.SysOrgMapper;
import org.clb.mybatisTest.service.CircleService;
import org.clb.mybatisTest.service.SysOrgService;
import org.clb.mybatisTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysOrgServiceImpl implements SysOrgService {

    @Resource
    SysOrgMapper sysOrgMapper;
    @Autowired
    private CircleService circleService;
    @Autowired
    private UserService userService;
    @Override
    public List<SysOrg> list() {
        return sysOrgMapper.selectAllList();
    }
}
