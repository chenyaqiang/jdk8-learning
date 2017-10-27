package com.booxJ.muti_programming;

/**
 * @description:死锁
 * @author: wb
 * @data: 2017/10/27 11:02
 * @see:
 * @since:
 */
public class Demo_07 implements Runnable{

    A a = new A();
    B b = new B();

    Demo_07(){
        Thread.currentThread().setName("Main Thread");
        Thread thread = new Thread(this,"Racing Thread");
        thread.start();
        a.foo(b);
        System.out.println("Back in main thread");
    }

    public void run() {
        b.bar(a);
        System.out.println("Back in other thread");
    }

    public static void main(String[] args){
        new Demo_07();
    }
}

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered A.foo");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("A interrupted");
        }

        System.out.println(name + "  trying to call B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }

}

class B {

    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.foo");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("B interrupted");
        }

        System.out.println(name + " trying to call A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }


}