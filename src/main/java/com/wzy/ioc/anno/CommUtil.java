package com.wzy.ioc.anno;

/**
 * @ClassName CommUtil
 * @Desc TODO
 * @Author Administrator
 * @Date 2019/7/2 14:41
 **/
public class CommUtil {

    /**
     * 根据传入的对象获取对应的sql
     * @param object
     * @return
     */
    public static String getQuerySql(Object object) {
        Class clazz = object.getClass();
        //判断类上是否有该注解
        if(clazz.isAnnotationPresent(SelfDefinitionAnno.class)) {
            SelfDefinitionAnno anno = (SelfDefinitionAnno) clazz.getAnnotation(SelfDefinitionAnno.class);
            String tableName = anno.value();
            return "select * from "+tableName;
        }
        return null;
    }

}
