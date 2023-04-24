package src.main.java.org.bcit.midterm.mysolution;

import java.util.ArrayList;

public class Intermediate_05_ClockManager {
    // Intermediate Question 05 (10 points, 2 TODOs)
    // Idea: tests your ability to create systems of classes.

    // README FIRST
    // I will ONLY be reading from this package:
    //   org.bcit.comp2522.winter2023.midterm.answers
    //
    // TODO 0: Create a copy of this file in the answers package.
    // Put your answers in new classes that are labeled with the
    // question label, e.g., Intermediate_05_myClass. Name them something
    // useful, other than "myClass", that is just an example.

    // TODO 1: Create a system of classes such that:
    // (0) Each of the classes below is prefixed with Intermediate_05_
    // (1) There is an abstract class called Clock
    // (2) AlarmClock and WallClock extend Clock
    // (3) There is an abstract class called Timer that does NOT extend clock
    // (4) StopWatch and AlarmTimer extend Timer
    // (5) There is an interface called Tickable
    // (6) There is an interface called Alarmable

    // TODO 2: Decide the best design for the interfaces and classes.
    // Hint: everything in and around the main method below should compile.
    // Follow SOLID principles and include example methods in the interface
    // and classes. You may leave comments or stubs instead of internal method logic.

    static ArrayList<Intermediate_05_Clock> clocks = new ArrayList<>();
    static ArrayList<Intermediate_05_Timer> timers = new ArrayList<>();
    static ArrayList<Intermediate_05_Tickable> tickables = new ArrayList<>();
    static ArrayList<Intermediate_05_Alarmable> alarmables = new ArrayList<>();
//    ArrayList<Intermediate_05_Clock> clocks = new ArrayList<>();
//    ArrayList<Intermediate_05_Timer> timers = new ArrayList<>();
//    ArrayList<Intermediate_05_Tickable> tickables = new ArrayList<>();
//    ArrayList<Intermediate_05_Alarmable> alarmables = new ArrayList<>();


    public static void main(String[] args) {
        Intermediate_05_Clock alarmClock = new Intermediate_05_AlarmClock();
        Intermediate_05_Clock wallClock = new Intermediate_05_WallClock();
        Intermediate_05_Timer stopWatch = new Intermediate_05_StopWatch();
        Intermediate_05_Timer alarmTimer = new Intermediate_05_AlarmTimer();

        clocks.add(alarmClock);
        clocks.add(wallClock);

        timers.add(stopWatch);
        timers.add(alarmTimer);

        tickables.add(alarmClock);
        tickables.add(wallClock);
        tickables.add(stopWatch);
        tickables.add(alarmTimer);

        alarmables.add((Intermediate_05_Alarmable) alarmClock);
        alarmables.add((Intermediate_05_Alarmable) alarmTimer);

        for (Intermediate_05_Tickable tickable : tickables) {
            tickable.tick();
        }
        for (Intermediate_05_Alarmable alarmable : alarmables) {
            alarmable.setAlarm(1000);
        }
    }
}
