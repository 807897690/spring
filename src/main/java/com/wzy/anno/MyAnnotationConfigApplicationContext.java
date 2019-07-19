package com.wzy.anno;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzy
 * @title: MyAnnotationConfigApplicationContext
 * @description: TODO
 * @date 2019/7/8 21:37
 */
public class MyAnnotationConfigApplicationContext {

    private Map<String, Object> beanMap = new HashMap<String, Object>();

    public MyAnnotationConfigApplicationContext(String basePackage) {
        parseBasePackage(basePackage);
    }

    public void parseBasePackage(String basePackage) {
        String path = this.getClass().getResource("/").getPath();
        String basePackagePath = basePackage.replaceAll("\\.","\\\\");
        File file = new File(path + "/" + basePackagePath);
        List<String> names = classNames(file);
        System.out.println(names);
        for (String name : names) {
            name = name.replace(".class", "");
            name = name.substring(name.indexOf("classes\\")+8, name.length());
            name = name.replaceAll("\\\\", "\\.");
            try {
                Class clazz = Class.forName(name);
                String beanName = null;
                Object object = null;
                if(clazz.isAnnotationPresent(MyServiceAnno.class)) {
                    MyServiceAnno anno = (MyServiceAnno) clazz.getAnnotation(MyServiceAnno.class);
                    beanName = anno.value();
                    object = clazz.newInstance();
                }else if(clazz.isAnnotationPresent(MyControllerAnno.class)) {
                    MyControllerAnno anno = (MyControllerAnno) clazz.getAnnotation(MyControllerAnno.class);
                    beanName = anno.value();
                    object = clazz.newInstance();
                }else if(clazz.isAnnotationPresent(MyRepositoryAnno.class)) {
                    MyRepositoryAnno anno = (MyRepositoryAnno) clazz.getAnnotation(MyRepositoryAnno.class);
                    beanName = anno.value();
                    object = clazz.newInstance();
                }
                if(object != null) {
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        Class fieldClass = field.getType();
                        if(field.isAnnotationPresent(MyAutowireAnno.class)) {
                            MyAutowireAnno anno = field.getAnnotation(MyAutowireAnno.class);
                            String fieldName = anno.value();
                            Object fieldObject = fieldClass.newInstance();
                            if(StringUtils.isEmpty(fieldName) && fieldObject != null) {
                                fieldName = fieldObject.getClass().getSimpleName();
                            }
                            System.out.println("beanName: "+ fieldName + ",object: "+ fieldObject);
                            beanMap.put(fieldName, fieldObject);
                        }
                    }
                }
                if(StringUtils.isEmpty(beanName) && object != null) {
                    beanName = object.getClass().getSimpleName();
                }
                System.out.println("beanName: "+ beanName + ",object: "+ object);
                beanMap.put(beanName, object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getBean(String beanName) {
        return beanMap.get(beanName);
    }

    private List<String> classNames(File file) {
        List<String> namse = new ArrayList<String>();
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()) {
                namse.addAll(classNames(file1));
            }else {
                namse.add(file1.getPath());
            }
        }
        return namse;
    }

}
