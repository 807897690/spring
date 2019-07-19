package com.wzy.aop.one;

import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @title: OrderDao
 * @description: TODO
 * @date 2019/7/2 20:54
 */
@Component
public class IndexDao implements Dao{
//    @TestAnnotation
    public void test() {
        System.out.println("test");
    }

    public void test(String str) {
        System.out.println(str);
    }
}
