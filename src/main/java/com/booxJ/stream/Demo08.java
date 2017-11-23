package com.booxJ.stream;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * @description:使用Spliterator迭代器
 * @author: wb
 * @data: 2017/11/23 11:03
 * @see:
 * @since:
 */
public class Demo08 {

    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Phi");
        myList.add("Omega");

        Stream<String> myStream = myList.stream();
        Spliterator<String> spliterator = myStream.spliterator();

        while (spliterator.tryAdvance(n->System.out.println(n)));
    }
}
