package com.wzy.aop.one;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName ExampleAspect
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 15:42
 **/
@Component("aspect")
@Aspect("perthis(this(com.wzy.aop.one.IndexDao2))")
@Scope("prototype")
public class ExampleAspect {

//    @DeclareParents(value = "com.wzy.aop.one.*", defaultImpl = IndexDao2.class)
//    public static dao dao;

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

    @Pointcut("target(IndexDao2))")
    public void pointTarget() {

    }

//    @Before("pointWithin() && !pointArgs()")
//    @Before("pointWithin()")
    public void advice() {
        System.out.println("before");
    }

//    @After("pointWithin()")
    public void after() {
        System.out.println("after");
    }

    @Around("pointWithin()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println(this.hashCode());
        Object[] args = proceedingJoinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            args[i] += " world";
        }
        System.out.println("around before");
        try {
            proceedingJoinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after");
    }


}
