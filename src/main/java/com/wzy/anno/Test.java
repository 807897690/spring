package com.wzy.anno;

/**
 * @author wzy
 * @title: Test
 * @description: TODO
 * @date 2019/7/8 21:52
 */
public class Test {

    public static void main(String[] args) {
        MyAnnotationConfigApplicationContext context =
                new MyAnnotationConfigApplicationContext("com.wzy.anno");
        DemoService demoService = (DemoService) context.getBean("DemoService");
        demoService.test();
        DemoService2 demoService2 = (DemoService2) context.getBean("demo2");
        demoService2.test();
    }

}
