package com.wzy.aop.one;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName AspectConfig
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 15:41
 **/
@Configuration
@ComponentScan("com.wzy.aop.one")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {
}
