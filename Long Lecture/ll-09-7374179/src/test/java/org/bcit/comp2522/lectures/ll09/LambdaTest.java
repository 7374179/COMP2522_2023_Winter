package org.bcit.comp2522.lectures.ll09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LambdaTest {
  Lambda lambda = new Lambda();
  @Test
  void add2() {
    int res = lambda.add(1, 2);
    assertEquals(3, res);
  }

  @Test
  void add3() {
    int res = lambda.add(1, 2, 3);
    assertEquals(6, res);
  }
  @Test
  void add4() {
    int res = lambda.add(1, 2, 3, 4);
    assertEquals(10, res);
  }

  @Test
  void add5() {
    int res = lambda.add(1, 2, 3, 4, 5);
    assertEquals(15, res);
  }

  @Test
  void add6() {
    int res = lambda.add(1, 2, 3, 4, 5, 6);
    assertEquals(21, res);
  }

  @Test
  void add7() {
    int res = lambda.add(1, 2, 3, 4, 5, 6, 7);
    assertEquals(28, res);
  }

  @Test
  void mult10() {
    int res = lambda.mult(2,2,2,2,2,2,2,2,2,2);
    assertEquals(1024, res);
  }

}