package com.wzy.ioc.loop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName Example1Service
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 11:55
 **/
@Component
@Scope("prototype")
public class Example1Service {

    @Autowired
    private Example2Service example2Service;

}
