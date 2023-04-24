package org.bcit.comp2522.lectures.sl02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {
  Logger logger;
  Date date;

  @BeforeEach
  void setup() {
    logger = new Logger();
    date = new Date();
  }

  @Test
  @DisplayName("Trivial test.")
  void trivialTest() {
    assertTrue(true);
  }

  @Test
  @DisplayName("Check logger output.")
  void decorateLogInput() {
    String s = String.format("%s : %s", date.toString(), "Hello, world!");
    assertEquals(s,
      logger.log("Hello, world!"),
      "Decorated the log with a date.");
  }
}