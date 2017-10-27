package com.booxJ.lambda;

/**
 * @description:泛型中的方法引用
 * @author: wb
 * @data: 2017/10/27 14:57
 * @see:
 * @since:
 */
public class Demo_07 {

    static <T> int myOp(MyFunc_07<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String args[]) {
        Integer[] vals = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strs = {"one", "two", "three", "two"};

        int count;

        count = myOp(MyArrayOps::<Integer>countMaching, vals, 4);
        System.out.println("vals contains " + count + " 4s");

        count = myOp(MyArrayOps::<String>countMaching, strs, "two");
        System.out.println("srs contains " + count + " two");
    }
}


interface MyFunc_07<T> {
    int func(T[] vals, T v);
}

class MyArrayOps {
    static <T> int countMaching(T[] vals, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == v) count++;
        }

        return count;
    }
}