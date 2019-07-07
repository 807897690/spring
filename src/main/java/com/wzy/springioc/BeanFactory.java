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
        File file = new File(this.getClass().getResource("/").getPath()+"//"+xml);
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(file);
            Element root = document.getRootElement();
            Attribute autowire = root.attribute("default-autowire");
            boolean flag = false;
            if(autowire != null) {
                flag = true;
            }
            for (Iterator<Element> itFirst = root.elementIterator(); itFirst.hasNext();) {
                Element element = itFirst.next();
                String beanName = element.attribute("id").getValue();
                String className = element.attribute("class").getValue();
                Class clazz = Class.forName(className);
                Object targetObject = null;
                for (Iterator<Element> itSecond = element.elementIterator(); itSecond.hasNext();) {
                    Element elementSecond = itSecond.next();
                    if(elementSecond.getName().equals("property")) {
                        targetObject = clazz.newInstance();
                        String refName = elementSecond.attribute("ref").getValue();
                        String nameValue = elementSecond.attribute("name").getValue();
                        Object injectObject = map.get(refName);
                        Field field = clazz.getDeclaredField(nameValue);
                        field.setAccessible(true);
                        field.set(targetObject, injectObject);
                    }else if(elementSecond.getName().equals("constructor-arg")) {
                        String refName = elementSecond.attribute("ref").getValue();
                        String nameValue = elementSecond.attribute("name").getValue();
                        Object injectObject = map.get(refName);
                        Class injectObjectClazz = injectObject.getClass();
                        Constructor constructor = clazz.getConstructor(injectObjectClazz.getInterfaces()[0]);
                        targetObject = constructor.newInstance(injectObject);
                    }
                }
                if(flag) {
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
                                throw new RuntimeException("找到多个对象");
                            }else {
                                targetObject = clazz.newInstance();
                                field.setAccessible(true);
                                field.set(targetObject, injectObject);
                            }
                        }
                    }
                }
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
