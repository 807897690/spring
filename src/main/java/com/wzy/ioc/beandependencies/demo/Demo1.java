package com.wzy.ioc.beandependencies.demo;

import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @title: Demo1
 * @description: TODO
 * @date 2019/7/18 14:41
 */
@Component
public class Demo1 {

    private Demo2 demo2;

    public Demo2 getDemo2() {
        return demo2;
    }

    public void setDemo2(Demo2 demo2) {
        this.demo2 = demo2;
    }
}
