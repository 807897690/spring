package com.wzy.proxy.dynamics_proxy;

import java.lang.reflect.Method;

/**
 * @author wzy
 * @title: TestInvocationHandler
 * @description: TODO
 * @date 2019/7/6 11:47
 */
public interface TestInvocationHandler {

    public Object invoke(Method method, Object... args);

}
