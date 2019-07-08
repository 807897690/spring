package com.wzy.springioc;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wzy
 * @title: BeanFactory
 * @description: TODO
 * @date 2019/7/7 12:35
 */
public class BeanFactory {

    private Map<String, Object> map = new HashMap<String, Object>();

    public BeanFactory(String xml) {
        parseXml(xml);
    }

    private void parseXml(String xml) {
        //拿取相应位置的xml文件
        File file = new File(this.getClass().getResource("/").getPath()+"//"+xml);
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            //解析xml文件
            document = reader.read(file);
            //获取根标签
            Element root = document.getRootElement();
            //查看根标签是否含有属性default-autowire
            Attribute autowire = root.attribute("default-autowire");
            boolean flag = false;
            if(autowire != null) {
                flag = true;
            }
            //遍历根标签下的子标签
            for (Iterator<Element> itFirst = root.elementIterator(); itFirst.hasNext();) {
                Element element = itFirst.next();
                //获取子标签的属性
                String beanName = element.attribute("id").getValue();
                String className = element.attribute("class").getValue();
                Class clazz = Class.forName(className);
                Object targetObject = null;
                //遍历子标签下的子标签
                for (Iterator<Element> itSecond = element.elementIterator(); itSecond.hasNext();) {
                    Element elementSecond = itSecond.next();
                    //如果标签名为property，则根据属性名称注入
                    if(elementSecond.getName().equals("property")) {
                        targetObject = clazz.newInstance();
                        String refName = elementSecond.attribute("ref").getValue();
                        String nameValue = elementSecond.attribute("name").getValue();
                        Object injectObject = map.get(refName);
                        Field field = clazz.getDeclaredField(nameValue);
                        field.setAccessible(true);
                        field.set(targetObject, injectObject);
                    }else if(elementSecond.getName().equals("constructor-arg")) {//如果标签名为constructor-arg，则根据构造方法注入
                        String refName = elementSecond.attribute("ref").getValue();
                        Object injectObject = map.get(refName);
                        Class injectObjectClazz = injectObject.getClass();
                        Constructor constructor = clazz.getConstructor(injectObjectClazz.getInterfaces()[0]);
                        targetObject = constructor.newInstance(injectObject);
                    } else{//其他默认为无法识别的标签
                        throw new  MyException("无法识别的标签");
                    }
                }
                //如果根标签上有default-autowire属性，则根据属性的值来注入
                if(flag && targetObject == null) {
                    if(autowire.getValue().equals("byType")) {
                        Field fields[] = clazz.getDeclaredFields();
                        int count = 0;
                        Object injectObject = null;
                        for (Field field : fields) {
                            Class injectObjectClazz = field.getType();
                            for(String key : map.keySet()) {
                                Class temp = map.get(key).getClass().getInterfaces()[0];
                                if(temp.getName().equals(injectObjectClazz.getName())) {
                                    injectObject = map.get(key);
                                    count++;
                                }
                            }
                            if(count > 1) {
                                throw new  MyException("找到多个对象");
                            }else {
                                targetObject = clazz.newInstance();
                                field.setAccessible(true);
                                field.set(targetObject, injectObject);
                            }
                        }
                    }else if(autowire.getValue().equals("byName")) {
                        Field fields[] = clazz.getDeclaredFields();
                        Object injectObject = null;
                        int byNameCount = 0;
                        for (Field field : fields) {
                            String fieldName = field.getName();
                            injectObject = map.get(fieldName);
                            if(injectObject != null) {
                                byNameCount++;
                            }
                            //如果根据byName查询不到，则根据byType查询
                            if(injectObject == null) {
                                int count = 0;
                                Class injectObjectClazz = field.getType();
                                for (String key : map.keySet()) {
                                    Class temp = map.get(key).getClass().getInterfaces()[0];
                                    if (temp.getName().equals(injectObjectClazz.getName())) {
                                        injectObject = map.get(key);
                                        count++;
                                    }
                                }
                                if (count > 1) {
                                    throw new  MyException("根据byType找到多个对象,属性名:"+fieldName+ ",对象："+clazz.getName());
                                } else {
                                    targetObject = clazz.newInstance();
                                    field.setAccessible(true);
                                    field.set(targetObject, injectObject);
                                }
                            }else {
                                if(byNameCount > 1) {
                                    throw new  MyException("根据byName找到多个对象,属性名:"+fieldName+ ",对象："+clazz.getName());
                                } else {
                                    targetObject = clazz.newInstance();
                                    field.setAccessible(true);
                                    field.set(targetObject, injectObject);
                                }
                            }
                        }
                    }
                }
                //标签没有子标签，默认根据无参构造函数初始化
                if(targetObject == null) {
                    targetObject = clazz.newInstance();
                }
                map.put(beanName, targetObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }

    public Object getBean(String name) {
        return map.get(name);
    }

}
