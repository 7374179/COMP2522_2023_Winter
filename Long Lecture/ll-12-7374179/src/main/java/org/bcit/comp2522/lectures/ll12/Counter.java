package org.bcit.comp2522.lectures.ll12;

import java.util.Random;

public class Counter {
  private int c = 0;

  public void increment() {
    c++;
  }

  public void decrement() {
    c--;
  }

  public int value() {
    return c;
  }
}
