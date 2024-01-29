package org.clb.mybatisTest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {


    @Pointcut("execution(* org.clb.mybatisTest.service.impl.*.*(..))")
    public void pointcut(){

    }

    @Before(value = "pointcut()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行...");
    }
}
