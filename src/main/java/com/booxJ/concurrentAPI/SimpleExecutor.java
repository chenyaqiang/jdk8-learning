package com.booxJ.concurrentAPI;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:一个简单的执行器示例
 * @author: wb
 * @data: 2017/12/22 15:42
 * @see:
 * @since:
 */
public class SimpleExecutor {

    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);

        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Starting");

        es.execute(new SeThread(cd1, "A"));
        es.execute(new SeThread(cd2, "B"));
        es.execute(new SeThread(cd3, "C"));
        es.execute(new SeThread(cd4, "D"));


        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        es.shutdown();
        System.out.println("Done!");
    }
}


class SeThread implements Runnable {

    String name;
    CountDownLatch latch;

    SeThread(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;

        new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ":" + i);
            latch.countDown();
        }
    }
}