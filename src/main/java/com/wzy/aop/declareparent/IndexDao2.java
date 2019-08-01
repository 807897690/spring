package com.wzy.aop.declareparent;

import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @title: IndexDao1
 * @description: TODO
 * @date 2019/8/1 15:16
 */
@Component
public class IndexDao2 implements Dao2{

    @Override
    public void testDao2() {
        System.out.println("dao2");
    }
}
