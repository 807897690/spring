package com.wzy.springioc;

/**
 * @author wzy
 * @title: Test
 * @description: TODO
 * @date 2019/7/7 13:08
 */
public class Test {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("springioc.xml");
        UserDao dao = (UserDao) beanFactory.getBean("dao");
        dao.test();
    }

}
