package com.wzy.aop.one;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wzy
 * @title: TestThisTarget
 * @description: TODO
 * @date 2019/7/2 21:18
 */
public class TestThisTarget {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        Dao dao = (Dao) context.getBean("indexDao2");
        Dao dao1 = (Dao) context.getBean("indexDao2");
        System.out.println(dao.hashCode() + "---" + dao.hashCode());
        dao.test("hello");
        dao1.test("haha");
    }

}
