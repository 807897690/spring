package com.wzy.proxy.dynamics_proxy;


import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
//        Dao dao = (Dao) ProxyUtil.newInstance(new DemoDao());
//        dao.test();
//        System.out.println(dao.set("test"));
//        System.out.println(dao.set("hello", "world"));

        //JDK动态代理
        long start = System.currentTimeMillis();
        Dao dao = (Dao) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{Dao.class}, new MyInvocationHandler(new DemoDao()));
        dao.test();
        System.out.println(dao.set("aaaaaaa"));
        System.out.println(dao.set("aaaaaaa", "bbbbbbbbbbbbbbbbbbbbbbbbbb"));
        System.out.println((System.currentTimeMillis() - start) + "ms");

//        TestInvocationHandler invocationHandler = new TestInvocationHandlerImpl(new DemoDao());
//        $Proxy proxy = new $Proxy(invocationHandler);
//        proxy.test();

        start = System.currentTimeMillis();
        Dao dao1 = (Dao) ProxyUtilJDK.newInstance(Dao.class, new TestInvocationHandlerImpl(new DemoDao()));
        dao1.test();
        System.out.println(dao1.set("aaaaaaa"));
        System.out.println(dao1.set("aaaaaaa", "bbbbbbbbbbbbbbbbbbbbbbbbbb"));
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }

}
