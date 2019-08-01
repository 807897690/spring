package com.wzy.aop.declareparent;

import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @title: IndexDao1
 * @description: TODO
 * @date 2019/8/1 15:16
 */
@Component
public class IndexDao1 implements Dao1{
    @Override
    public void test() {
        System.out.println("dao1");
    }
}
