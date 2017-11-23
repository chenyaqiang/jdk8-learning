package com.booxJ.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @description:映射例子1
 * @author: wb
 * @data: 2017/11/23 9:57
 * @see:
 * @since:
 */
public class Demo04 {

    public static void main(String[] args) {

        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        Stream<Double> sqrtRootStream = myList.stream().map(n -> Math.sqrt(n));

        double productOfSqrRoots = sqrtRootStream.reduce(1.0, (a, b) -> a * b);

        System.out.println("Product of square roots is " + productOfSqrRoots);
    }
}
