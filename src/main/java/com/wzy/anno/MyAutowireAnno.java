package com.wzy.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wzy
 * @title: MyAutowireAnno
 * @description: TODO
 * @date 2019/7/8 21:57
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAutowireAnno {

    String value() default "";
}
