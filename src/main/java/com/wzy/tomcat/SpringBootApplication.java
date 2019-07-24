package com.wzy.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @author wzy
 * @title: SpringBootApplication
 * @description: TODO
 * @date 2019/7/24 21:37
 */
public class SpringBootApplication {

    public static void run() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8769);
        tomcat.addWebapp("/","d:\\wzy\\");
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        tomcat.getServer().await();
    }

}
