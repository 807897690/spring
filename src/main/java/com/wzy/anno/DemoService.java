package com.wzy.anno;

/**
 * @author wzy
 * @title: DemoService
 * @description: TODO
 * @date 2019/7/8 21:53
 */
@MyServiceAnno
public class DemoService {

    @MyAutowireAnno("demo2")
    private DemoService2 demoService2;

    public void test() {
        System.out.println("spring anno test");
    }

}
