package org.clb.mybatisTest.service.impl;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao extends SqlSessionDaoSupport {

    /**
     * Autowired 必须要有
     */
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){

        super.setSqlSessionFactory(sqlSessionFactory);
    }

}