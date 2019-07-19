package com.wzy.aop.two.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @title: SpringAop
 * @description: TODO
 * @date 2019/7/19 16:19
 */
@Component
@Aspect
public class SpringAop {

    @Pointcut("execution(* com.wzy.aop.two.service..*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        System.out.println("proxy before");
    }


}
