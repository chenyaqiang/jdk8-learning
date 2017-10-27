package com.booxJ.lambda;

/**
 * @description:
 * @author: wb
 * @data: 2017/10/27 13:56
 * @see:
 * @since:
 */
public class Demo_02 {

    public static void main(String[] args) {

        NumericTest isEven = (n) -> (n % 2 == 0);
        if (isEven.test(10)) System.out.println("10 is even");
        if (!isEven.test(9)) System.out.println("9 is not even");

        NumericTest isNonNeg = (n) -> n >= 0;
        if (isNonNeg.test(1)) System.out.println("1 is non-negative");
        if (!isNonNeg.test(-1)) System.out.println("-1 is negative");
    }
}


interface NumericTest {
    boolean test(int n);
}