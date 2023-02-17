package org.clb.mybatisTest.service.impl;

import org.springframework.stereotype.Component;

@Component("DdAbstractAcServiceImpl")
public class DdAbstractAcServiceImpl extends AbstractAcService{
    @Override
    void say() {
        System.out.println("ddddddddddd");
    }
}
