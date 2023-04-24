package src.main.java.org.bcit.midterm.mysolution;

public abstract class Intermediate_05_Clock implements Intermediate_05_Tickable {
    protected int hours;
    protected int minutes;
    protected int seconds;

//    public Intermediate_05_Clock(int hours, int minutes, int seconds) {
//        this.hours = hours;
//        this.minutes = minutes;
//        this.seconds = seconds;
//    }

    public abstract void displayTime();

    public abstract void tick();
}
