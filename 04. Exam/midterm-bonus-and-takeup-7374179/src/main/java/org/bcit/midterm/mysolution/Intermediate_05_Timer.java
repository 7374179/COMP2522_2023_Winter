package src.main.java.org.bcit.midterm.mysolution;

public abstract class Intermediate_05_Timer implements Intermediate_05_Tickable {
  protected int seconds;

//  public Intermediate_05_Timer(int seconds) {
//    this.seconds = seconds;
//  }

  public abstract void displayTime();

  public abstract void reset();

  public abstract void start();

  public abstract void stop();
}