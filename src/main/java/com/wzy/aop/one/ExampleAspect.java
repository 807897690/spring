package com.wzy.aop.one;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName ExampleAspect
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 15:42
 **/
@Component
@Aspect
public class ExampleAspect {

    @Pointcut("execution(* com.wzy.aop.one..*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void advice() {
        System.out.println("example test before");
    }

}
