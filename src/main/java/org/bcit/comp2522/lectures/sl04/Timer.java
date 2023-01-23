package org.bcit.comp2522.lectures.sl04;

public class Timer {
  public long last = 0;
  public long curr = 0;
  public final long start;
  private static Timer timer;

  private Timer() {
    start = System.nanoTime();
  };

  public static Timer getInstance() {
    if (timer == null) {
      timer = new Timer();
    }
    return timer;
  }

  public long now() {
    return System.nanoTime();
  }

  public void time() {
    this.update();
    this.print();
  }

  public void update() {
    last = curr;
    curr = System.nanoTime();
  }

  // Should return frames per second for a given difference
  // between now and then
  public long fps(long nano) {
    double seconds = nano * Math.pow(10, -9);
    long calc = (long) (1/seconds);
    return calc;
  }

  // Should print in the format of:
  // Last: %d\tCurr: %d\tDiff: %d\tFPS: %\d\n
  public void print() {
    long diff = curr - last;
    System.out.format("Last: %d\tCurr: %d\tDiff: %d\tFPS: %d\n", last,curr,diff,fps(diff));
  };

}
