package org.bcit.comp2522.winter2023.midterm.bonus;

public class Intermediate_05_StopWatch extends Intermediate_05_Timer{
    private int elapsedSeconds;

//    public Intermediate_05_StopWatch(int seconds) {
//        super(seconds);
//        elapsedSeconds = 0;
//    }

    @Override
    public void displayTime() {
        System.out.println("Stop Watch: " + elapsedSeconds + " seconds");
    }

    @Override
    public void reset() {
        elapsedSeconds = 0;
    }

    @Override
    public void start() {
        // start the timer
    }

    @Override
    public void stop() {
        // stop the timer
    }
}