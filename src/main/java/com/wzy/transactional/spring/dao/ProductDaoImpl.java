package com.wzy.transactional.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author wzy
 * @title: ProductDaoImpl
 * @description: TODO
 * @date 2019/7/19 14:33
 */
@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void update() {
        jdbcTemplate.update("insert into `product` (`id`, `name`) values ('1','name')", (Map<String, ?>) null);
        System.out.println(1/0);
    }
}
