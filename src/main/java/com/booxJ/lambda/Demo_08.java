package com.booxJ.lambda;

/**
 * @description:通过静态工厂创建构造函数
 * @author: wb
 * @data: 2017/10/27 15:31
 * @see:
 * @since:
 */
public class Demo_08 {

    static <R, T> R myClassFactory(MyFunc_08<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFunc_08<MyClass<Double>, Double> myClassCons = MyClass<Double>::new;
        MyClass<Double> mc = myClassFactory(myClassCons, 100.1);

        System.out.println("val in mc is " + mc.getVal());

        MyFunc_08<MyClass2,String> myClassCons2 = MyClass2::new;

        MyClass2 mc2 = myClassFactory(myClassCons2,"lambda");
        System.out.println("str in mc2 is " + mc2.getStr());
    }
}

interface MyFunc_08<R, T> {
    R func(T t);
}

class MyClass<T> {
    private T val;

    MyClass(T v) {
        val = v;
    }

    MyClass() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

class MyClass2 {
    String str;

    MyClass2(String s) {
        str = s;
    }

    MyClass2() {
        str = "";
    }

    public String getStr() {
        return str;
    }
}