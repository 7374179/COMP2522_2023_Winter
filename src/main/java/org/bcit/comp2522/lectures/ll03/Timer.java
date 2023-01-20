package org.bcit.comp2522.lectures.ll03;

public class Timer {
  public long last = 0;
  public long curr = 0;
  
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
    return 0;
  }

  // Should print in the format of:
  // Last: %d\tCurr: %d\tDiff: %d\tFPS: %d\n
  public void print() {};

}
