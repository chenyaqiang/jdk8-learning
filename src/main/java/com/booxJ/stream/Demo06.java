package com.booxJ.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:收集——从流中获得集合
 * @author: wb
 * @data: 2017/11/23 10:38
 * @see:
 * @since:
 */
public class Demo06 {

    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@123.com"));
        myList.add(new NamePhoneEmail("James", "444-4444", "James@123.com"));
        myList.add(new NamePhoneEmail("Mary", "333-3333", "Mary@123.com"));

        Stream<NamePhone> namePhone = myList.stream().map(a -> new NamePhone(a.name, a.phone));

        //获取list
        List<NamePhone> namePhoneList = namePhone.collect(Collectors.toList());
        //更多控制
//        namePhoneList = namePhone.collect(
//                () -> new ArrayList<>(),
//                (list, element) -> list.add(element),
//                (listA, listB) -> listA.addAll(listB));

        System.out.println("Names and phone in a List:");
        for (NamePhone e : namePhoneList) {
            System.out.println(e.name + " " + e.phone);
        }

        namePhone = myList.stream().map(a -> new NamePhone(a.name, a.phone));
        //获取Set
        Set<NamePhone> namePhoneSet = namePhone.collect(Collectors.toSet());
        //更多控制
//        namePhoneSet = namePhone.collect(HashSet::new, HashSet::add, HashSet::addAll);
        System.out.println("\nNames and phone in a Set:");
        for (NamePhone e : namePhoneSet) {
            System.out.println(e.name + " " + e.phone);
        }
    }
}

