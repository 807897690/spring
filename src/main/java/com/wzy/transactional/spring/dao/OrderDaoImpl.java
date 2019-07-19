package com.wzy.transactional.spring.dao;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author wzy
 * @title: OrderDaoImpl
 * @description: TODO
 * @date 2019/7/19 14:31
 */
@Component
public class OrderDaoImpl implements OrderDao, ApplicationContextAware {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ProductDao productDao;

    private ApplicationContext applicationContext;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void update() {
        jdbcTemplate.update("insert into `order` (`id`, `name`) values ('1','name')", (Map<String, ?>) null);
        try {
            /**
             * 第一种方法，实现ApplicationContextAware，通过ApplicationContext获取其代理对象
             */
//            OrderDao orderDao = applicationContext.getBean(OrderDao.class);
//            orderDao.updateProduct();
            /**
             * 第二种
             */
            OrderDao orderDao = (OrderDao) AopContext.currentProxy();
            orderDao.updateProduct();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateProduct() {
        jdbcTemplate.update("insert into `product` (`id`, `name`) values ('1','name')", (Map<String, ?>) null);
        System.out.println(1/0);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
