package com.wzy.proxy.dynamics_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wzy
 * @title: MyInvocationHandler
 * @description: TODO
 * @date 2019/7/6 11:40
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invocationHandler");
        return method.invoke(target, args);
    }
}
