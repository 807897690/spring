package com.wzy.ioc.loop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName LoopTest
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 11:54
 **/
public class LoopTest {

    /**
     * 循环依赖  当多个类循环依赖时，全部都是单例时，spring容器可以初始化成功
     * 当全部是原型时，则报错：org.springframework.beans.factory.BeanCurrentlyInCreationException
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LoopConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for(String name : names) {
            System.out.println(name);
        }
        System.out.println(context.getBean(Example2Service.class).getClass().getSimpleName());
    }

}
