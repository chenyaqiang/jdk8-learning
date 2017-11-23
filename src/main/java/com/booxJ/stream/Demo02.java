package com.booxJ.stream;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @description:缩减操作
 * @author: wb
 * @data: 2017/11/22 17:01
 * @see:
 * @since:
 */
public class Demo02 {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Original list:" + myList);

        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);
        if (productObj.isPresent()) {
            System.out.println("Product as Optional: " + productObj.get());
        }

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product as int: " + product);

    }
}
