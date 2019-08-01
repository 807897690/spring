package com.wzy.aop.declareparent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wzy
 * @title: Test
 * @description: TODO
 * @date 2019/8/1 15:18
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        Dao2 dao2 = (Dao2) context.getBean("indexDao2");
        dao2.testDao2();
        Dao1 dao = (Dao1) dao2;
        dao.test();
    }

}
