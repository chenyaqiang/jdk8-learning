package com.booxJ.lambda;

/**
 * @description:例子
 * @author: wb
 * @data: 2017/10/27 13:50
 * @see:
 * @since:
 */
public class Demo_01 {
    public static void main(String[] args) {
        MyNumber myNum;

        myNum = () -> 123.45;
        System.out.println(myNum.getValue());

        myNum = () -> Math.random() * 100;
        System.out.println(myNum.getValue());
        System.out.println(myNum.getValue());

    }

}


interface MyNumber {
    double getValue();
}