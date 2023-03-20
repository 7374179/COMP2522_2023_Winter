package org.bcit.comp2522.lectures.sl12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
  static long sum(int[] nums) {
    return 0;
  }

  static long sum(int[] nums, int i, int j) {
    return 0;
  }

  public static void main(String[] args) throws InterruptedException {
    int total = (int) Math.pow(2, 29);
    int[] nums = new int[total];

    long start = System.nanoTime();
    long out = 0; // TODO: make this more reasonable
    // TODO
    long end = System.nanoTime();
    System.out.format("%3d threads: Time was %d for sum %d over total %d numbers.\n", end - start, out, total);

    AtomicLong sum1 = new AtomicLong();
    AtomicLong sum2 = new AtomicLong();

    start = System.nanoTime();
    // TODO
    end = System.nanoTime();
    System.out.format("%3d threads: Time was %d for sum %d over total %d numbers.\n", end - start, out, total);


    int num_threads = (int) Math.pow(2, 5);
    Thread[] threads = new Thread[num_threads];
    AtomicLong[] outputs = new AtomicLong[num_threads];

    // TODO
    System.out.format("%3d threads: Time was %d for sum %d over total %d numbers.\n", num_threads, end - start, out, total);








  }
}