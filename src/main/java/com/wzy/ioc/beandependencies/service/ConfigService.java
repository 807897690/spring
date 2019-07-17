package com.wzy.ioc.beandependencies.service;

import com.wzy.ioc.beandependencies.dao.ConfigDao;
import com.wzy.ioc.beandependencies.dao.ConfigDao1;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wzy
 * @title: ConfigService
 * @description:
 * mybatis-spring:一级缓存失效原因：由于spring在做完一次操作后，会将SqlSessionFactory关闭
 * 二级缓存指的是多个线程共享:二级缓存是根据命名空间隔离的，所以更新时只会更新当前命名空间下的缓存
 * mybatis中解析mapper的方式有4中：url、import、class、package
 * @date 2019/7/17 15:09
 */
@Service
public class ConfigService {

    @Autowired
    ConfigDao configDao;
    @Autowired
    ConfigDao1 configDao1;

    public List<Map<String, String>> query(){
        return configDao.query();
    }

    public void update() {
        configDao.update();
    }

}
