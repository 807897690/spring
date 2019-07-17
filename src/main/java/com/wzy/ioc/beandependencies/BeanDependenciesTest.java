package com.wzy.ioc.beandependencies;

import com.wzy.ioc.beandependencies.service.ConfigService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName BeanDependenciesTest
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 11:22
 **/
public class BeanDependenciesTest {
    /**
     * bean生成的依赖
     */
    public static void main(String[] args) {
//        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanDependenciesConfig.class);
        System.out.println(context.getBean(ConfigService.class).query());
        context.getBean(ConfigService.class).update();
        System.out.println(context.getBean(ConfigService.class).query());
    }
}
