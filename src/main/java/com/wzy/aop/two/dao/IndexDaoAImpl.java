package com.wzy.aop.two.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @title: IndexDaoAImpl
 * @description: TODO
 * @date 2019/7/19 16:12
 */
@Component
@Primary
public class IndexDaoAImpl implements IndexDao{

    @Override
    public void test(String str) {
        System.out.println("A");
        System.out.println(str);
    }
}
