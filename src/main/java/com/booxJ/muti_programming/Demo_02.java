package com.booxJ.muti_programming;

/**
 * @description:实现Runnable接口
 * @author: wb
 * @data: 2017/10/26 16:57
 * @see:
 * @since:
 */
public class Demo_02 {

    public static void main(String[] args) {
        new newThread_02();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread：" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }
        System.out.println("Main Thread exiting");
    }
}

class newThread_02 implements Runnable {

    Thread thread;

    newThread_02() {
        thread = new Thread(this, "Demo_02 Thread");
        System.out.println("Child Thread：" + thread);
        thread.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread：" + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Interrupted");
        }
        System.out.println("Child Thread exiting");
    }
}
