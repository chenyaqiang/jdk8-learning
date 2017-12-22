package com.booxJ.concurrentAPI.Fork_Join.RecursiveTask;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @description:创建返回结果的任务需要用到RecursiveTask
 * @author: wb
 * @data: 2017/12/22 16:27
 * @see:
 * @since:
 */
public class Sum extends RecursiveTask<Double> {

    final int seqThreshold = 500;

    double[] data;

    int start, end;

    public Sum(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        double sum = 0;

        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (start + end) / 2;
            Sum subSumA = new Sum(data, start, middle);
            Sum subSumB = new Sum(data, middle, end);
//            invokeAll(subSumA,subSumB);
            subSumA.fork();
            subSumB.fork();

            sum = subSumA.join() + subSumB.join();
        }
        return sum;
    }
}

class RecursiveTaskDemo {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        double[] nums = new double[5000];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextDouble() * 10;
        }

        //同步
        Sum task = new Sum(nums, 0, nums.length);
        double summation = pool.invoke(task);

        //异步
//        ForkJoinTask<Double> task1 = new Sum(nums, 0, nums.length);
//        pool.execute(task1);

        System.out.println("summation:" + summation);
    }
}
