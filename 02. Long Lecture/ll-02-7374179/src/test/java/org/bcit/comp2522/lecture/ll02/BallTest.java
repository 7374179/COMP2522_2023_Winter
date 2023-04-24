package org.bcit.comp2522.lecture.ll02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
  Ball ball0;
  Ball ball1;
  Box box2;

  Window window;
  Collidable[] collidables;

  @BeforeEach
  void setup() {
    window = new Window();
    collidables = new Collidable[2];
    ball0 = new Ball(100, 100, 25, 0, collidables, window);
    ball1 = new Ball(100, 100, 20, 0, collidables, window);
    collidables[0] = ball0;
    collidables[1] = ball1;

    box2 = new Box(20, 20, 100, 100, 2, collidables, window);
  }

  @Test
  void testBall0EqualsBall0() {
    assertEquals(ball0, ball0);
  }

  @Test
  void testBall0DNEBall1() {
    assertNotEquals(ball0, ball1);
  }

  @Test
  void testBallDNEBox() {
    assertNotEquals(ball0, box2);
  }

  @Test
  void testCompareLessThan() {
//    assertTrue(ball1.compareTo(ball0) < -1);
  }

  @Test
  void testSort() {
    List l = new ArrayList<Collidable>(List.of(collidables));
    System.out.println(l);
    Collections.sort(l);
    System.out.println(l);
    assertTrue(l.get(1) == ball0);
  }
}