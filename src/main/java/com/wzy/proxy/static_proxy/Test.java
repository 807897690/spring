package com.wzy.proxy.static_proxy;

public class Test {

    public static void main(String[] args) {
        /**
         * 静态代理的继承实现
         */
        Dao dao = new DemoLogDao();
        dao.test();

        /**
         * 静态代理的聚合实现
         */
        Dao demoDao = new DemoDao();
        Dao dao2 = new DemoLog2Dao((DemoDao)demoDao);
        dao2.test();
    }

}
