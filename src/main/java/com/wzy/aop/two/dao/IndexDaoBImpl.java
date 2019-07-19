package com.wzy.aop.two.dao;

import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @title: IndexDaoAImpl
 * @description: TODO
 * @date 2019/7/19 16:12
 */
@Component
public class IndexDaoBImpl implements IndexDao{
    
    @Override
    public void test(String str) {
        System.out.println("B");
        System.out.println(str);
    }
}
