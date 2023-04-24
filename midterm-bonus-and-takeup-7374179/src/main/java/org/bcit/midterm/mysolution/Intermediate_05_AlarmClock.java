package src.main.java.org.bcit.midterm.mysolution;

public class Intermediate_05_AlarmClock extends Intermediate_05_Clock implements Intermediate_05_Alarmable{
    private int alarmSeconds;

//    public Intermediate_05_AlarmClock(int hours, int minutes, int seconds, int alarmSeconds) {
//        super(hours, minutes, seconds);
//        this.alarmSeconds = alarmSeconds;
//    }

    @Override
    public void setAlarm(int seconds) {
        this.alarmSeconds = seconds;
    }

    @Override
    public void displayTime() {
        System.out.println("Alarm Clock: " + hours + ":" + minutes + ":" + seconds);
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
        if (seconds == alarmSeconds) {
            System.out.println("Alarm Clock: Ring Ring Ring!!!");
        }
    }
}