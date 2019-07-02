package com.wzy.ioc.loop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName Example2Service
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 11:55
 **/
@Component
@Scope("prototype")
public class Example2Service {

    @Autowired
    private Example1Service example1Service;

}
