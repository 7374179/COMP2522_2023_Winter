package src.main.java.org.bcit.midterm.mysolution;

public class Intermediate_05_WallClock extends Intermediate_05_Clock{
//    public Intermediate_05_WallClock(int hours, int minutes, int seconds) {
//        super(hours, minutes, seconds);
//    }

    @Override
    public void displayTime() {
        System.out.println("Wall Clock: " + hours + ":" + minutes + ":" + seconds);
    }

    @Override
    public void tick() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes >= 60) {
            minutes = 0;
            hours++;
        }
        if (hours >= 24) {
            hours = 0;
        }
    }
}