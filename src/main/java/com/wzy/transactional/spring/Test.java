package com.wzy.transactional.spring;

import com.wzy.transactional.spring.config.Config;
import com.wzy.transactional.spring.dao.OrderDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wzy
 * @title: Test
 * @description: TODO
 * @date 2019/7/19 14:34
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean(OrderDao.class).update();
    }

}
