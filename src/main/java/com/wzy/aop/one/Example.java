package com.wzy.aop.one;

import org.springframework.stereotype.Component;

/**
 * @ClassName Example
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 15:41
 **/
@Component
public class Example {

    @TestAnnotation
    public void test(String str) {
        System.out.println("example test");
    }

    public void test() {
        System.out.println("example test");
    }

}
