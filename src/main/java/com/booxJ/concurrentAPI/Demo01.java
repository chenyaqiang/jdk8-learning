package com.booxJ.concurrentAPI;

import java.util.concurrent.Semaphore;

/**
 * @description:Semaphore
 * @author: wb
 * @data: 2017/11/23 13:37
 * @see:
 * @since:
 */
public class Demo01 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        new IncThread("A", semaphore);
        new DecThread("B", semaphore);
    }
}


class Shared {
    static int count = 0;
}

class IncThread implements Runnable {

    String name;
    Semaphore sem;

    IncThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ":" + Shared.count);
                Thread.sleep(10);
            }

        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " release the permit.");
        sem.release();
    }
}

class DecThread implements Runnable {

    String name;
    Semaphore sem;

    DecThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");

            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ":" + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " release the permit.");
        sem.release();
    }
}