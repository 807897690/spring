package com.wzy.aop.one;

import org.springframework.stereotype.Repository;

/**
 * @ClassName IndexDao2
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/3 9:25
 **/
@Repository
public class IndexDao2 implements Dao{
    public void test() {
        System.out.println("dao2");
    }
}
