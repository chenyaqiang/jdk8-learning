package com.booxJ.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @description:使用传统迭代器Iterator
 * @author: wb
 * @data: 2017/11/23 10:55
 * @see:
 * @since:
 */
public class Demo07 {

    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Phi");
        myList.add("Omega");

        Stream<String> myStream = myList.stream();

        Iterator<String> itr = myStream.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
