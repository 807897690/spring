package com.wzy.ioc.profile;

import com.wzy.ioc.profile.pro.ProConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName ProfileTest
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 12:08
 **/
public class ProfileTest {

    /**
     * profile 区分环境使用
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("pro");
        context.register(ProConfig.class);
        context.refresh();
        System.out.println(context.getBean(ProConfig.class).getClass().getSimpleName());
    }

}
