package com.wzy.proxy.static_proxy;

/**
 * 静态代理的继承实现
 */
public class DemoLogDao extends DemoDao{

    @Override
    public void test() {
        System.out.println("test work for log");
        super.test();
    }
}
