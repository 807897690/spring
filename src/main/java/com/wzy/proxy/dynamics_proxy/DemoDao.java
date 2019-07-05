package com.wzy.proxy.dynamics_proxy;

public class DemoDao implements Dao {

    public void test() {
        System.out.println("test work for db");
    }

    public String set(String str) {
        return str;
    }

    @Override
    public String set(String str, String str2) {
        return str+"-----"+str2;
    }
}
