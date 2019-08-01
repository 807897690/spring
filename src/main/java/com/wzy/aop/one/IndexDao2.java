package com.wzy.aop.one;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @ClassName IndexDao2
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/3 9:25
 **/
@Repository
//@Scope("prototype")
public class IndexDao2 implements Dao{
    public void test() {
        System.out.println("dao2");
    }

    public void test(String str) {
        System.out.println("dao2");
        System.out.println(str);
    }
}
