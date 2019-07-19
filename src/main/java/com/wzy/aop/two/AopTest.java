package com.wzy.aop.two;

import com.wzy.aop.two.config.AopConifg;
import com.wzy.aop.two.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wzy
 * @title: AopTest
 * @description: TODO
 * @date 2019/7/19 16:22
 */
public class AopTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConifg.class);
        context.getBean(IndexService.class).test("B");
    }

}
