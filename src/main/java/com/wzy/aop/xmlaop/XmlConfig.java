package com.wzy.aop.xmlaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wzy
 * @title: XmlConfig
 * @description: TODO
 * @date 2019/7/3 19:28
 */
@ComponentScan("com.wzy.aop.xmlaop")
@ImportResource(locations = "classpath:spring.xml")
public class XmlConfig {
}
