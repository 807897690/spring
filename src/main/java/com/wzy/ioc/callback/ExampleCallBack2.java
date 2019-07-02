package com.wzy.ioc.callback;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName ExampleCallBack2
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 10:51
 **/
@Component
public class ExampleCallBack2 implements InitializingBean, DisposableBean {

    public ExampleCallBack2() {
        System.out.println("Constructor ExampleCallBack2");
    }

    public void destroy() throws Exception {
        System.out.println("ExampleCallBack2 destory");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("ExampleCallBack2 init");
    }
}
