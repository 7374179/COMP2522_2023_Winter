package org.bcit.comp2522.lectures.sl12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
  static long sum(int[] nums) {
    long acc = 0;
    for (int i = 0; i < nums.length; i++) {
      acc = acc + nums[i];
    }
    return acc;
  }

  static long sum(int[] nums, int i, int j) {
    long acc = 0;
    for (int k = i; k < j; k++) {
      acc = acc + nums[k];
    }
    return acc;
  }
  public static void main(String[] args) throws InterruptedException {
    int total = (int) Math.pow(2, 10);
    int[] nums = new int[total];
    for (int i = 0; i < total; i++) {
      nums[i] = i;
    }

    long start = System.nanoTime();
//    long out = 0; // TODO: make this more reasonable
    long out = sum(nums); // TODO: make this more reasonable
    // TODO
    long end = System.nanoTime();
    System.out.format("%3d threads: Time was %d for sum %d over total %d numbers.\n", 1, end - start, out, total);

    AtomicLong sum1 = new AtomicLong();
    AtomicLong sum2 = new AtomicLong();

    Thread t1 = new Thread(() -> sum1.set(sum(nums, 0, total / 2)));
    Thread t2 = new Thread(() -> sum2.set(sum(nums, total / 2, total)));

    start = System.nanoTime();

    // TODO
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    out = sum1.get() + sum2.get();

    end = System.nanoTime();
    System.out.format("%3d threads: Time was %d for sum %d over total %d numbers.\n", 2, end - start, out, total);

    // Initialize on atomic long array
    // Initialize the thread array

    int num_threads = (int) Math.pow(2, 5);
    Thread[] threads = new Thread[num_threads];
    AtomicLong[] outputs = new AtomicLong[num_threads];

    // TODO

    for (int i = 0; i < num_threads; i++) {
      outputs[i] = new AtomicLong();
    }
    // 0 1 | 2 3  | 4 5 | 6 7
    int block = total / num_threads;
    for (int i = 0; i < num_threads; i++) {
      int finalI = i;
      threads[i] = new Thread(() ->
          outputs[finalI].set(
              sum(nums, finalI * block, (finalI + 1) * block)));
    }
    start = System.nanoTime();
    for(int i=0;i<num_threads;i++){
      threads[i].start();
    }
    for(int i=0;i<num_threads;i++){
      threads[i].join();
    }
    end = System.nanoTime();

    out = 0;
    for(int i=0;i<num_threads;i++){
      out=out+outputs[i].get();
    }
    System.out.format("%3d threads: Time was %d for sum %d over total %d numbers.\n", num_threads, end - start, out, total);

  }
}