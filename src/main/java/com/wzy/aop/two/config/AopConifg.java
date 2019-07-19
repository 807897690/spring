package com.wzy.aop.two.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wzy
 * @title: AopConifg
 * @description: TODO
 * @date 2019/7/19 16:19
 */
@Configuration
@ComponentScan("com.wzy.aop.two")
@EnableAspectJAutoProxy
public class AopConifg {
}
