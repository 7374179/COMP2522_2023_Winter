package org.bcit.comp2522.lectures.ll03;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  private Timer timer;

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outContent));
    timer = new Timer();
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  void fps() {
    double example = 16383600 * Math.pow(10, -9);
    long calc = (long) (1/example);
    assertEquals(calc, timer.fps(16383600));
  }

  @Test
  void print() {
    long curr = 776346905391100l;
    long then = curr - 16383600l;
    timer.last = then;
    timer.curr = curr;
    String expected = String.format("Last: %d\tCurr: %d\tDiff: %d\tFPS: %d\n",then,curr,curr - then, 61);
    timer.print();
    assertEquals(expected, outContent.toString());
  }
}