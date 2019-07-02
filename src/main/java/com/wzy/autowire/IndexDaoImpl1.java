package com.wzy.autowire;

import org.springframework.stereotype.Repository;

/**
 * @ClassName IndexDaoImpl1
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 9:19
 **/
@Repository
public class IndexDaoImpl1 implements  IndexDao{
    public void test() {
        System.out.println("impl1");
    }
}
