package com.booxJ.muti_programming;

/**
 * @description:拓展Thread类
 * @author: wb
 * @data: 2017/10/27 9:58
 * @see:
 * @since:
 */
public class Demo_03 {

    public static void main(String[] args){

        new newThread_03();
        try {
            for (int i=5;i>0;i--){
                System.out.println("Main Thread:"+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main Thread exiting");
    }

}

class newThread_03 extends Thread{

    newThread_03(){
        super("Demo_03 Thread");
        System.out.println("Child thread:"+this);
        start();
    }

    public void run(){
        try{
            for (int i=5;i>0;i--){
                System.out.println("Child thread:"+i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Child Interrupted");
        }
        System.out.println("Child Thread exiting");
    }
}
