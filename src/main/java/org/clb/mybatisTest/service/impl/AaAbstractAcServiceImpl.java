package org.clb.mybatisTest.service.impl;

import org.springframework.stereotype.Component;

@Component("AaAbstractAcServiceImpl")
public class AaAbstractAcServiceImpl extends AbstractAcService{
    @Override
    void say() {
        System.out.println("aaaaaaaaa");
    }
}
