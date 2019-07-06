package com.wzy.proxy.dynamics_proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wzy
 * @title: TestInvocationHandlerImpl
 * @description: TODO
 * @date 2019/7/6 11:48
 */
public class TestInvocationHandlerImpl implements TestInvocationHandler{

    private Object target;

    public TestInvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Method method, Object... args) {
        System.out.println("testInvocationHandler");
        try {
            return method.invoke(target, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
