package com.booxJ.concurrentAPI.Fork_Join.RecursiveAction;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @description:RecursiveAction针对不返回结果的任务
 * @author: wb
 * @data: 2017/12/22 16:07
 * @see:
 * @since:
 */
public class SqrtTransform extends RecursiveAction {

    final int seqThreashold = 100;

    double[] data;

    int start, end;

    SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreashold) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }
    }
}

class ForkJoinDemo {
    public static void main(String[] args) {

        //jdk8开始，存在公共池
        //ForkJoinPool pool = new ForkJoinPool();
        ForkJoinPool pool = ForkJoinPool.commonPool();

        double[] nums = new double[10000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        System.out.println("原始队列的数据为：");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
//        task.invoke();
        pool.invoke(task);

        System.out.println("求完平方根后的数据为：");
        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f ", nums[i]);
        }
    }
}
