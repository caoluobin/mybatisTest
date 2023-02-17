package org.clb.mybatisTest.service.impl;

import org.clb.mybatisTest.service.AcService;

public abstract class AbstractAcService implements AcService {

    abstract void say();

    public void run() {
        say();
    }
}
