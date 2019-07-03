package com.wzy.aop.xmlaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wzy
 * @title: XmlTest
 * @description: TODO
 * @date 2019/7/3 19:29
 */
public class XmlTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(XmlConfig.class);
        XmlDemo xmlDemo = (XmlDemo) context.getBean("xmlDemo");
        xmlDemo.test();
    }

}
