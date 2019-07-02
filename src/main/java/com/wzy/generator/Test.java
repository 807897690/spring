package com.wzy.generator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Test
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 9:09
 **/
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        String[] names = context.getBeanDefinitionNames();
        for(String name : names) {
            System.out.println(name);
        }
    }

}
