package com.booxJ.concurrentAPI;

import java.util.concurrent.*;

/**
 * @description:
 * @author: wb
 * @data: 2017/12/22 15:52
 * @see:
 * @since:
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        Future<Integer> f1;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("Starting");

        f1 = es.submit(new Sum(10));
        f2 = es.submit(new Hypot(3,4));
        f3 = es.submit(new Factorial(10));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();
        System.out.println("Done!");
    }
}


//求和
class Sum implements Callable<Integer> {

    int stop;

    Sum(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}

//求三角形第三边长
class Hypot implements Callable<Double> {

    double s1, s2;

    Hypot(double s1, double s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt((s1 * s1) + (s2 * s2));
    }
}

//求阶乘
class Factorial implements Callable<Integer> {

    int stop;

    Factorial(int stop) {
        this.stop = stop;
    }


    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 0; i <= stop; i++) {
            fact *= i;
        }
        return fact;
    }
}