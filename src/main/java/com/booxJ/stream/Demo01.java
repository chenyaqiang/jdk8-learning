package com.booxJ.stream;

import java.util.*;
import java.util.stream.*;

/**
 * @description:流示例
 * @author: wb
 * @data: 2017/11/22 16:33
 * @see:
 * @since:
 */
public class Demo01 {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Original list:" + myList);

        //查询最小值
        Stream<Integer> myStream = myList.stream();
        Optional<Integer> minVal = myStream.min(Integer::compare);
        if (minVal.isPresent()) System.out.println("Minimum value:" + minVal.get());

        //查询最大值
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        if (maxVal.isPresent()) System.out.println("Maximum value:" + maxVal.get());

        //排序
        Stream<Integer> sortedStream = myList.stream().sorted();
        System.out.print("Sorted stream:");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        //筛选基数
        Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.print("Odd Vals:");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        //多条件筛选 基数&大于5
        oddVals = myList.stream().filter(n->(n%2)==1).filter(n->n>5);
        System.out.print("Odd values greater than 5:");
        oddVals.forEach((n) -> System.out.print(n + " "));
    }
}
