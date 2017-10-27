package com.booxJ.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @description:单成员注解
 * @author: wb
 * @data: 2017/10/27 13:45
 * @see:
 * @since:
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MySingle {
    int value();
}
