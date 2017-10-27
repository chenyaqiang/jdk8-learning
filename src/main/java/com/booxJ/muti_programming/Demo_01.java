package com.booxJ.muti_programming;

/**
 * @description:主线程
 * @author: wb
 * @data: 2017/10/26 16:52
 * @see:
 * @since:
 */
public class Demo_01 {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Current thread:" + t);

        t.setName("Main Thread");

        try {
            for (int i=5;i>0;i--){
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
    }
}
