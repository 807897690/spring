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
        IndexDao dao = (IndexDao) context.getBean(IndexDao.class);
        System.out.println(dao instanceof  Dao);
        dao.test();
    }

}
