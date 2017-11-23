package com.booxJ.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @description:映射例子2
 * @author: wb
 * @data: 2017/11/23 10:01
 * @see:
 * @since:
 */
public class Demo05 {

    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@123.com"));
        myList.add(new NamePhoneEmail("James", "444-4444", "James@123.com"));
        myList.add(new NamePhoneEmail("Mary", "333-3333", "Mary@123.com"));

        System.out.println("Original values in myList:");
        myList.stream().forEach(n -> {
            System.out.println(n.name + " " + n.phone + " " + n.email);
        });

        System.out.println("\nList of names and phone:");
        Stream<NamePhone> namePhone = myList.stream().map(n -> new NamePhone(n.name, n.phone));
        namePhone.forEach(n->{
            System.out.println(n.name + " " + n.phone);
        });

        System.out.println("\nList of names equal James:");
        namePhone = myList.stream().filter(n->n.name.equals("James")).map(n->new NamePhone(n.name,n.phone));
        namePhone.forEach(n->{
            System.out.println(n.name + " " + n.phone);
        });
    }

}

class NamePhoneEmail {
    String name;
    String phone;
    String email;

    public NamePhoneEmail(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phone;

    public NamePhone(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone;
    }
}