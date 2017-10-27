package com.booxJ.lambda;

/**
 * @description:泛型函数式接口
 * @author: wb
 * @data: 2017/10/27 14:09
 * @see:
 * @since:
 */
public class Demo_04 {
    public static void main(String[] args) {
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i = 0;
            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("lambda reversed is " + reverse.func("lambda"));

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println("The factorial of 3 is " + factorial.func(3));
        System.out.println("The factorial of 5 is " + factorial.func(5));
    }
}


interface SomeFunc<T> {
    T func(T t);
}