package org.bcit.comp2522.lectures.sl03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterTest {
  Letter s = new Letter("S");
  Letter p = new Letter("P");
  Letter g = new Letter("G");

  @Test
  void testSEqualS() {
    assertTrue(s.compareTo(s) == 0);
  }
  @Test
  void testSOrderP() {
    assertTrue(s.compareTo(p) == -1);
  }
  @Test
  void testSOrderG() {
    assertTrue(s.compareTo(g) == -1);
  }
  @Test
  void testGOrderS() {
    assertTrue(g.compareTo(s) == 1);
  }
  @Test
  void testGOrderP() {
    assertTrue(g.compareTo(p) == 1);
  }

  @Test
  void testAll() {
    for (int i = 1; i < Letter.order.length(); i++) {
      Letter a = new Letter(Letter.order.charAt(i - 1));
      Letter b = new Letter(Letter.order.charAt(i));
      assertTrue(a.compareTo(b) < 0);
      assertTrue(b.compareTo(a) > 0);
      assertTrue(a.compareTo(a) == 0);
      assertTrue(b.compareTo(b) == 0);
    }
  }





}