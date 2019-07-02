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

    @Pointcut("within(com.wzy.aop.one.*))")
    public void pointWithin() {

    }

    @Pointcut("args(java.lang.String))")
    public void pointArgs() {

    }

//    @Pointcut("@annotation(TestAnnotation))")
//    public void pointAnnotation() {
//
//    }

    @Pointcut("this(IndexDao))")
    public void pointThis() {

    }

    @Pointcut("target(IndexDao))")
    public void pointTarget() {

    }

//    @Before("pointWithin() && !pointArgs()")
    @Before("pointTarget()")
    public void advice() {
        System.out.println("example test before");
    }



}
