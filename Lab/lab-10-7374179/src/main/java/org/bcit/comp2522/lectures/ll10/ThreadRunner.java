package org.bcit.comp2522.lectures.ll10;

// Make a new class called ThreadRunner
// be a parallel version of sum
// take: integer array
// return: sum
// Hint: spawn threads in a for-loop
// e.g {1, 2, 3, 4} -> 10
public class ThreadRunner {
  public static volatile int sum = 0;

  public static void main(String[] args){
    int size = 100;
    int[] arr = new int[size];
    Thread[] threads = new Thread[size];

    for(int i=0;i<size;i++){
//      sum = sum + i;
      arr[i] = i;
//      sum = sum+i;
  }
    for(int i=0;i<size;i++){
      int index = i;
//        Thread.sleep(1000);
//      new Thread(() -> sum = sum + arr[index]);
      Thread t = new Thread(() -> sum = sum + arr[index]);
      threads[i]=t;
      t.start();
//      sum = sum + arr[i];
    }
    for(int i=0;i<size;i++){
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
//    try {
//      Thread.sleep(10000);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
    System.out.format("The sum should be: %d\n", (size*size - size)/2);
    System.out.format("The sum is: %d\n", sum);
  }

}
