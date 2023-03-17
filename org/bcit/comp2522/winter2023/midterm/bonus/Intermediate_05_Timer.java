package org.bcit.comp2522.winter2023.midterm.bonus;

public abstract class Intermediate_05_Timer {
  protected int seconds;

//  public Intermediate_05_Timer(int seconds) {
//    this.seconds = seconds;
//  }

  public abstract void displayTime();

  public abstract void reset();

  public abstract void start();

  public abstract void stop();
}