package com.wzy.aop.two.service;

import com.wzy.aop.two.dao.IndexDao;
import com.wzy.aop.two.dao.IndexDaoBImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wzy
 * @title: IndexService
 * @description: TODO
 * @date 2019/7/19 16:17
 */
@Service
public class IndexService implements ApplicationContextAware {

    @Autowired
    private Map<String, IndexDao> map;

    @Autowired
    private IndexDao indexDao;

    private ApplicationContext applicationContext;

    public  void test(String name) {
        if(name.equals("B")) {
            indexDao = applicationContext.getBean(IndexDaoBImpl.class);
        }
        indexDao.test("test");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
