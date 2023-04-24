package src.main.java.org.bcit.midterm.mysolution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Intermediate_05_test {
        private ArrayList<Intermediate_05_Clock> clocks;
        private ArrayList<Intermediate_05_Timer> timers;
        private ArrayList<Intermediate_05_Tickable> tickables;
        private ArrayList<Intermediate_05_Alarmable> alarmables;

        @BeforeEach
        public void setUp() {
            clocks = new ArrayList<>();
            timers = new ArrayList<>();
            tickables = new ArrayList<>();
            alarmables = new ArrayList<>();
        }

        @Test
        public void testClock() {
            Intermediate_05_Clock alarmClock = new Intermediate_05_AlarmClock();
            Intermediate_05_Clock wallClock = new Intermediate_05_WallClock();

            assertTrue(alarmClock instanceof Intermediate_05_Clock);
            assertTrue(wallClock instanceof Intermediate_05_Clock);

            clocks.add(alarmClock);
            clocks.add(wallClock);

            assertEquals(clocks.size(), 2);
            assertTrue(clocks.contains(alarmClock));
            assertTrue(clocks.contains(wallClock));
        }

        @Test
        public void testTimer() {
            Intermediate_05_Timer stopWatch = new Intermediate_05_StopWatch();
            Intermediate_05_Timer alarmTimer = new Intermediate_05_AlarmTimer();

            assertTrue(stopWatch instanceof Intermediate_05_Timer);
            assertTrue(alarmTimer instanceof Intermediate_05_Timer);

            timers.add(stopWatch);
            timers.add(alarmTimer);

            assertEquals(timers.size(), 2);
            assertTrue(timers.contains(stopWatch));
            assertTrue(timers.contains(alarmTimer));
        }

        @Test
        public void testTickable() {
            Intermediate_05_Clock alarmClock = new Intermediate_05_AlarmClock();
            Intermediate_05_Clock wallClock = new Intermediate_05_WallClock();
            Intermediate_05_Timer stopWatch = new Intermediate_05_StopWatch();
            Intermediate_05_Timer alarmTimer = new Intermediate_05_AlarmTimer();

            assertTrue(alarmClock instanceof Intermediate_05_Tickable);
            assertTrue(wallClock instanceof Intermediate_05_Tickable);
            assertTrue(stopWatch instanceof Intermediate_05_Tickable);
            assertTrue(alarmTimer instanceof Intermediate_05_Tickable);

            tickables.add(alarmClock);
            tickables.add(wallClock);
            tickables.add(stopWatch);
            tickables.add(alarmTimer);

            assertEquals(tickables.size(), 4);
            assertTrue(tickables.contains(alarmClock));
            assertTrue(tickables.contains(wallClock));
            assertTrue(tickables.contains(stopWatch));
            assertTrue(tickables.contains(alarmTimer));
        }

        @Test
        public void testAlarmable() {
            Intermediate_05_Clock alarmClock = new Intermediate_05_AlarmClock();
            Intermediate_05_Timer alarmTimer = new Intermediate_05_AlarmTimer();

            assertTrue(alarmClock instanceof Intermediate_05_Alarmable);
            assertTrue(alarmTimer instanceof Intermediate_05_Alarmable);

            alarmables.add((Intermediate_05_Alarmable) alarmClock);
            alarmables.add((Intermediate_05_Alarmable) alarmTimer);

            assertEquals(alarmables.size(), 2);
            assertTrue(alarmables.contains(alarmClock));
            assertTrue(alarmables.contains(alarmTimer));

    }
}