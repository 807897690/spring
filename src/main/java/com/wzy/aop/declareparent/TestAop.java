package com.wzy.aop.declareparent;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @title: TestAop
 * @description: TODO
 * @date 2019/8/1 15:17
 */
@Component
@Aspect
public class TestAop {

    @DeclareParents(value = "com.wzy.aop.declareparent.Dao2+", defaultImpl = IndexDao1.class)
    private static Dao1 dao;
}
