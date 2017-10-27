package com.booxJ.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @description:
 * @author: wb
 * @data: 2017/10/27 13:29
 * @see:
 * @since:
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str() default "string";
    int val() default 100;
}
