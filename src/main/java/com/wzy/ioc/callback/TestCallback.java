package com.wzy.ioc.callback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestCallback
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 10:43
 **/
public class TestCallback {

    /**
     * spring容器回调init以及destory的三种实现
     * Multiple lifecycle mechanisms configured for the same bean, with different initialization methods, are called as follows:
     * Methods annotated with @PostConstruct     1、在需要回调的方法上加上@PostConstruct注解
     * afterPropertiesSet() as defined by the InitializingBean callback interface    2、需要回调的方法所在的类实现InitializingBean的afterPropertiesSet()方法
     * A custom configured init() method    3、在xml文件中定义init-method
     *
     * Destroy methods are called in the same order:
     * Methods annotated with @PreDestroy  1、在需要回调的方法上加上@PreDestroy注解
     * destroy() as defined by the DisposableBean callback interface     2、需要回调的方法所在的类实现DisposableBean的destroy()方法
     * A custom configured destroy() method  3、在xml文件中定义destory-method
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CallBackConfig.class);
        context.close();
    }

}
