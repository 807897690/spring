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
 * mybatis-spring:一级缓存失效原因：
 *      是因为mybatis-spring中扩展了一个类为SqlSessionTemplate，这个类在spring容器启动得时候代替了
 *      原来mybatis中得DefaultSqlSession，SqlSessionTemplate当中得方法不是直接操作其方法，
 *      而是通过生成一个代理类，代理对象将其方法进行了扩展，在这个扩展中就包括了将session关闭得操作
 *
 * 二级缓存指的是多个线程共享:二级缓存是根据命名空间隔离的，所以更新时只会更新当前命名空间下的缓存
 *
 * mybatis中解析mapper的方式有4中：url、import、class、package
 *
 * mybatis+lo4j会打印log4j日志，mybatis+spring5+lo4j会打印jul日志：
 * 原因：mybatis底层默认使用jcl打印日志，在没有log4j的依赖情况下, 是用jul，如果有了log4j则使用log4j
 *      而加了spring5之后，spring5加了spring-jcl模块来打印日志，底层默认使用jul来打印日志，
 *      而在mybatis与spring5的整合jar包中，顺序使用为slf4j、jul、log4j2、log4j，所以这时会默认优先使用jul,
 *      而jul得默认打印日志级别为info,所以这时控制台上看不到日志
 *
 *
 *
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
