package com.booxJ.concurrentAPI;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:CyclicBarrier类，具有两个或以上的的线程必须在预定的执行点进行等待，直到所有线程都到达执行点为止
 * @author: wb
 * @data: 2017/12/22 15:15
 * @see:
 * @since:
 */
public class Demo04 {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        new MyThread04(cb,"A");
        new MyThread04(cb,"B");
        new MyThread04(cb,"C");
    }
}

class MyThread04 implements Runnable {
    CyclicBarrier cbar;
    String name;

    MyThread04(CyclicBarrier cbar, String name) {
        this.cbar = cbar;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cbar.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}

class BarAction implements Runnable {
    public void run() {
        System.out.println("Barrier Reached");
    }
}