package com.wzy.ioc.callback;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName ExampleCallBack
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 10:47
 **/
@Component
public class ExampleCallBack {

    public ExampleCallBack() {
        System.out.println("Constructor ExampleCallBack");
    }

    @PostConstruct
    public void init() {
        System.out.println("ExampleCallBack init");
    }

    @PreDestroy
    public void destory() {
        System.out.println("ExampleCallBack destory");
    }

}
