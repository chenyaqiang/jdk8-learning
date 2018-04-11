package com.booxJ.aop.jdk;

import com.booxJ.aop.UserService;
import com.booxJ.aop.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by viruser on 2018/4/11.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler() {
        super();
    }

    MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        if ("getName".equals(method.getName())) {
            System.out.println("++++++++++before " + method.getName() + "++++++++++");
            Object result = method.invoke(target, args);
            System.out.println("++++++++++after " + method.getName() + "++++++++++");
            return result;
        }else {
            Object result = method.invoke(target, args);
            return result;
        }
    }


    public static void main(String[] args){
        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),invocationHandler);
        System.out.println(userServiceProxy.getName("tom"));
        System.out.println(userServiceProxy.getAge(10));
    }
}
