package org.clb.mybatisTest.service.impl;

import org.clb.mybatisTest.entity.SysOrg;
import org.clb.mybatisTest.mapper.SysOrgMapper;
import org.clb.mybatisTest.service.SysOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysOrgServiceImpl implements SysOrgService {

    @Resource
    SysOrgMapper sysOrgMapper;

    @Override
    public List<SysOrg> list() {
        return sysOrgMapper.selectAllList();
    }
}
