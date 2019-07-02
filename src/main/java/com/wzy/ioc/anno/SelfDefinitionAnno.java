package com.wzy.ioc.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName SelfDefinitionAnno
 * @Desc 自定义注解
 * @Author Administrator
 * @Date 2019/7/2 14:39
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) //注解的生命周期
public @interface SelfDefinitionAnno {

    /**
     * 默认必须有值
     * @return
     */
    public String value();

}
