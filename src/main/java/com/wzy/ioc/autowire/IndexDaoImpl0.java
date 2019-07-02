package com.wzy.ioc.autowire;

import org.springframework.stereotype.Repository;

/**
 * @ClassName IndexDaoImpl0
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 9:18
 **/
@Repository
public class IndexDaoImpl0 implements IndexDao{

    public void test() {
        System.out.println("impl0");
    }
}
