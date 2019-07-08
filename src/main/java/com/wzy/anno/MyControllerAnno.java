package com.wzy.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wzy
 * @title: MyServiceAnno
 * @description: TODO
 * @date 2019/7/8 21:36
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyControllerAnno {

    String value() default "";

}
