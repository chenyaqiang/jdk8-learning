package com.booxJ.aop;

import com.booxJ.aop.UserService;

/**
 * Created by viruser on 2018/4/11.
 */
public class UserServiceImpl implements UserService {


    public String getName(String name) {
        System.out.println("----------getName---------");
        return name;
    }

    public Integer getAge(Integer age) {
        System.out.println("----------getAge---------");
        return age;
    }
}
