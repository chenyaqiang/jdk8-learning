package com.booxJ.lambda;

/**
 * @description:方法引用
 * @author: wb
 * @data: 2017/10/27 14:30
 * @see:
 * @since:
 */

/**
 * 静态方法引用格式 ClassName::methodName
 * 实例方法引用格式 objRef::methodName
 * 构造函数引用格式 className::new
 */
public class Demo_06 {
    static String stringOp(StringFunc_06 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "lambdas add power to Java";
        String outStr = "";

        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Original string:"+inStr);
        System.out.println("String reversed:"+outStr);
    }
}

interface StringFunc_06 {
    String func(String n);
}


class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}