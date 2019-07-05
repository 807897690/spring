package com.wzy.proxy.static_proxy;

import com.wzy.proxy.static_proxy.Dao;
/**
 * 静态代理的聚合实现，采用装饰模式
 */
public class DemoLog2Dao implements Dao{

    private DemoDao dao;

    public DemoLog2Dao(DemoDao dao) {
        this.dao = dao;
    }

    public void test() {
        System.out.println("test work for log");
        dao.test();
    }
}
