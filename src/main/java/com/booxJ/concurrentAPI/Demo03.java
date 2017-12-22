package com.booxJ.concurrentAPI;

import java.util.concurrent.CountDownLatch;

/**
 * @description:CountDownLatch类，线程进行等待，知道发生一个或多个事件为止
 * @author: wb
 * @data: 2017/11/23 14:10
 * @see:
 * @since:
 */
public class Demo03 {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);

        new MyThread(latch);
        System.out.println("Start");

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}


class MyThread implements Runnable {

    CountDownLatch latch;

    MyThread(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}