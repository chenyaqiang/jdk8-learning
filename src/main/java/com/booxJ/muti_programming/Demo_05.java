package com.booxJ.muti_programming;

/**
 * @description:使用synchronized同步
 * @author: wb
 * @data: 2017/10/27 10:27
 * @see:
 * @since:
 */
public class Demo_05 {

    public static void main(String[] args){
        Callme target = new Callme();
        Caller ob1 = new Caller(target,"Hello");
        Caller ob2 = new Caller(target,"Synchronized");
        Caller ob3 = new Caller(target,"Word");

        try {
            ob1.thread.join();
            ob2.thread.join();
            ob3.thread.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
}

class Callme{

    /*使用synchronized*/
    synchronized void call(String msg){
        System.out.print("["+msg);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable{

    String msg;
    Callme target;
    Thread thread;

    public Caller(Callme target,String msg){
        this.target = target;
        this.msg = msg;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        target.call(msg);
    }
}
