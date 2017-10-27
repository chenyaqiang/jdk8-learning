package com.booxJ.muti_programming;

/**
 * @description:线程间通信
 * @author: wb
 * @data: 2017/10/27 10:38
 * @see:
 * @since:
 */
public class Demo_06 {

    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Comsumer(q);
    }
}


class Q {
    int n;
    boolean isEmpty = true;

    synchronized int get() {
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got:" + n);
        isEmpty = true;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.n = n;
        isEmpty = false;
        System.out.println("Put:" + n);
        notify();
    }
}

class Producer implements Runnable {

    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}

class Comsumer implements Runnable {

    Q q;

    Comsumer(Q q) {
        this.q = q;
        new Thread(this, "Comsumer").start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}