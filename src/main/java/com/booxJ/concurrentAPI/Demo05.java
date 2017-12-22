package com.booxJ.concurrentAPI;

import java.util.concurrent.Exchanger;

/**
 * @description:Exchanger类，用于两个线程之间的数据交换
 * @author: wb
 * @data: 2017/12/22 15:29
 * @see:
 * @since:
 */
public class Demo05 {

    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();

        new UseString(exgr);
        new MakeString(exgr);
    }
}

class MakeString implements Runnable {

    Exchanger<String> ex;
    String str;

    MakeString(Exchanger<String> ex) {
        this.ex = ex;
        str = new String();
        new Thread(this).start();
    }

    @Override
    public void run() {

        char ch = 'A';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += ch++;
            }
        }

        try {
            str = ex.exchange(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class UseString implements Runnable {
    Exchanger<String> ex;
    String str;

    UseString(Exchanger<String> ex) {
        this.ex = ex;
        str = new String();

        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Got:" + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}