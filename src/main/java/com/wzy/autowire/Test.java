package com.wzy.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Test
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 9:20
 **/
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowireConfig.class);
        IndexService service = (IndexService) context.getBean(IndexService.class);
        service.service();
    }

}
