package com.wzy.ioc.beandependencies;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName BeanDependenciesTest
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 11:22
 **/
public class BeanDependenciesTest {
    /**
     * bean生成的依赖
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanDependenciesConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for(String name : names) {
            System.out.println(name);
        }
    }
}
