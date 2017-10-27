package com.booxJ.annotation;

import java.lang.reflect.Method;

/**
 * @description:获取注解
 * @author: wb
 * @data: 2017/10/27 13:31
 * @see:
 * @since:
 */
public class Meta {

    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth() {
        Meta ob = new Meta();

        try {
            Class<?> c = ob.getClass();

            Method method = c.getMethod("myMeth");

            MyAnno anno = method.getAnnotation(MyAnno.class);

            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    @MyAnno(str = "Two Parameters", val = 19)
    public static void myMeth(String str, int i) {
        Meta ob = new Meta();

        try {
            Class<?> c = ob.getClass();

            Method method = c.getMethod("myMeth", String.class, int.class);

            MyAnno anno = method.getAnnotation(MyAnno.class);

            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
        myMeth("test", 1);
    }
}
