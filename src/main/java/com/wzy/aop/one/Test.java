package com.wzy.aop.one;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName Test
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 15:45
 **/
public class Test {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
//        Example example = context.getBean(Example.class);
//        example.test("aa");
//        example.test();
//        IndexDao dao = (IndexDao)context.getBean(IndexDao.class);
//        System.out.println(dao instanceof  Dao);
//        dao.test();
        Class<?>[] interfaces = new Class[]{Dao.class};
        byte bytes[] = ProxyGenerator.generateProxyClass("TestProxy", interfaces);
        File file = new File("D:\\TestProxy.class");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
