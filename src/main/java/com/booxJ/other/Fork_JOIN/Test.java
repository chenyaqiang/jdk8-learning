package com.booxJ.other.Fork_JOIN;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @description:
 * @author: wb
 * @data: 2017/11/16 9:17
 * @see:
 * @since:
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // 创建随机数组成的数组:
        long[] array = new long[200];
        fillRandom(array);
        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(2); // 最大并发数2
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    private static void fillRandom(long[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + (((long) (new Random().nextDouble() * 10)));
        }
    }
}
