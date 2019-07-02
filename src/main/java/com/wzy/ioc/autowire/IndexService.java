package com.wzy.ioc.autowire;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName IndexService
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 9:19
 **/
@Service
public class IndexService {

    /**
     * error:@Autowired默认根据byType来查找，所以这里会查找到两个同一类型的实现类，spring无法确认调用哪一个
     * No qualifying bean of type 'com.wzy.ioc.autowire.IndexDao' available: expected single matching bean but found 2: indexDaoImpl0,indexDaoImpl1
     */
//    @Autowired
//    private IndexDao dao;
    /**
     * 同样出错，@Resource默认根据byName查找，没有指定名称的同时，默认会根据属性名称查询（这里就是根据dao查找），
     * 结果查找不到，然后会根据byType查找，结果跟@Autowired一样
     */
//    @Resource
//    private IndexDao dao;

    @Resource(type = IndexDaoImpl1.class)
    private IndexDao dao;

    public void service() {
        dao.test();
    }

}
