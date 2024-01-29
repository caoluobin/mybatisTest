package org.clb.mybatisTest.service.impl;

import org.clb.mybatisTest.exception.BusinessException;
import org.clb.mybatisTest.service.SysOrgService;
import org.clb.mybatisTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("AaAbstractAcServiceImpl")
public class AaAbstractAcServiceImpl extends AbstractAcService{

    @Autowired
    private SysOrgService sysOrgService;

    @Autowired
    private UserService userService;
    private String MD_UPLOAD_NAME_LEN;
    @Override
    void say() {
        System.out.println("aaaaaaaaa");

    }
}
