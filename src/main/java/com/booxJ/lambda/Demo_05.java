package com.booxJ.lambda;

/**
 * @description:作为参数传递lambda表达式
 * @author: wb
 * @data: 2017/10/27 14:13
 * @see:
 * @since:
 */
public class Demo_05 {
    static String stringOp(StringFunc_05 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "lambdas add power to Java";
        String outStr;

        System.out.println("Here is input string:" + inStr);

        outStr = stringOp(str -> str.toUpperCase(), inStr);
        System.out.println("The string in uppercase:" + outStr);

        outStr = stringOp(str -> {
            String result = "";
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }
            return result;
        }, inStr);
        System.out.println("The string with space removed:" + outStr);
    }
}


interface StringFunc_05 {
    String func(String str);
}