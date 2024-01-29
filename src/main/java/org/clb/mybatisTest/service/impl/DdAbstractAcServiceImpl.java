package org.clb.mybatisTest.service.impl;

import org.clb.mybatisTest.util.SpringContextUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("DdAbstractAcServiceImpl")
public class DdAbstractAcServiceImpl extends AbstractAcService{
    AbstractAcService abstractAcService;
    @PostConstruct
    public void init() {
//        abstractAcService = SpringContextUtil.getBean("AaAbstractAcServiceImpl");
    }
    @Override
    void say() {
        System.out.println("ddddddddddd");
    }
}
