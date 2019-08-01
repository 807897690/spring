package com.wzy.aop.declareparent;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wzy
 * @title: Appconfig
 * @description: TODO
 * @date 2019/8/1 15:15
 */
@Configuration
@ComponentScan("com.wzy.aop.declareparent")
@EnableAspectJAutoProxy
public class Appconfig {



}
