package com.wzy.ioc.generator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * @ClassName MyBeanNameGenerator
 * @Desc 实现spring容器中beanName的定义规则
 * @Author Administrator
 * @Date 2019/7/2 9:07
 **/
public class MyBeanNameGenerator implements BeanNameGenerator {
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {
        String beanClassName = beanDefinition.getBeanClassName();
        System.out.println("beanClassName:"+beanClassName);
        return beanClassName;
    }
}
