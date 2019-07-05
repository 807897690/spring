package com.wzy.proxy.dynamics_proxy;

public class Test {

    public static void main(String[] args) {
        Dao dao = (Dao) ProxyUtil.newInstance(new DemoDao());
        dao.test();
        System.out.println(dao.set("test"));
    }

}
