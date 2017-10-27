package com.booxJ.muti_programming;

/**
 * @description:创建多个线程
 * @author: wb
 * @data: 2017/10/27 10:10
 * @see:
 * @since:
 */
public class Demo_04 {

    public static void main(String[] args) {
//        new newThread_04("one");
//        new newThread_04("two");
//        new newThread_04("three");
//
//        try {
//            Thread.sleep(10000);
//        }catch (InterruptedException e) {
//            System.out.println("Main thread Interrupted");
//        }
//        System.out.println("Main thread exiting");

        /*用isAlive()和join改进*/
        newThread_04 ob1 = new newThread_04("one");
        newThread_04 ob2 = new newThread_04("two");
        newThread_04 ob3 = new newThread_04("three");

        System.out.println("Thread one is alive:" + ob1.thread.isAlive());
        System.out.println("Thread two is alive:" + ob1.thread.isAlive());
        System.out.println("Thread three is alive:" + ob1.thread.isAlive());

        try {
            System.out.println("Waiting for threads to finish..");
            ob1.thread.join();
            ob2.thread.join();
            ob3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Thread one is alive:" + ob1.thread.isAlive());
        System.out.println("Thread two is alive:" + ob1.thread.isAlive());
        System.out.println("Thread three is alive:" + ob1.thread.isAlive());

        System.out.println("Main thread exiting");

    }
}

class newThread_04 implements Runnable {

    String name;
    Thread thread;

    newThread_04(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("New thread：" + thread);
        thread.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ":" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " Interrupted");
        }
        System.out.println(name + " exiting");
    }
}
