package com.wzy.ioc.generator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Test
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 9:09
 **/
public class Test {

    /**
     * BeanFactory、FactoryBean的区别：
     * BeanFactory是IOC最基本的容器，负责生产和管理bean，它为其他具体的IOC容器提供了最基本的规范，例如DefaultListableBeanFactory,XmlBeanFactory,ApplicationContext 等具体的容器都是实现了BeanFactory
     * FactoryBean是一个接口，当在IOC容器中的Bean实现了FactoryBean后，通过getBean(String BeanName)获取到的Bean对象并不是FactoryBean的实现类对象，而是这个实现类中的getObject()方法返回的对象。要想获取FactoryBean的实现类，就要getBean(&BeanName)，在BeanName之前加上&
     */

    /**
     * 懒加载：本质上属于单例模式，如果一个类为懒加载，那么当类加载时不会实例化，只有当调用这个类时才会去实例化这个bean，但是不管调用多少次，只实例化一次
     * 原型模式：类加载时，不会实例化，当调用时才会实例化，每调用一次，实例化一次
     * spring 容器：是spring框架实现功能的核心，不仅仅帮我们创建了对象，它负责了对对象整个生命周期的管理（创建、装配、销毁）
     * spring IOC 容器：即控制反转，是一种编程思想，把对象创建、管理的控制权全部交给了spring
     * spring context:spring应用上下文，将我们配置好的bean加载利用上下文对象进spring容器，ApplicationContext，提供了多种类型的容器实现:AnnotationConfigApplicationContext（基于注解）,ClassPathXmlApplicationContext(基于xml文件)
     * @Condition  条件注册bean，只有当满足指定的条件才可以加载该bean
     * @Import： 快速给容器导入一个组件，在容器中key值是这个组件的全路径,例：com.wzy.service.Example3
     * @ImportSelector: 是一个接口，返回需要导入到容器的组件的全类名数组
     * @ImportBeanDefinitionRegistrar: 把所有需要添加到容器中的bean加入容器，可以根据条件筛选
     */

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        String[] names = context.getBeanDefinitionNames();
        for(String name : names) {
            System.out.println(name);
        }
    }

}
