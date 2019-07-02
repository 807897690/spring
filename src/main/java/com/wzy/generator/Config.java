package com.wzy.generator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Config
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 9:08
 **/
@Configuration
@ComponentScan(value = "com.wzy.generator", nameGenerator = MyBeanNameGenerator.class)
public class Config {
}
