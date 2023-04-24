package org.bcit.comp2522.lecture.sl06;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TreeCollectionTest {
  @Test
  void runTimeExceptionTest() {
    TreeCollection tc = new TreeCollection();
    assertThrows(RuntimeException.class, () -> tc.iterator());
  }

  @Test
  void noSuchElementExceptionText() {
    TreeCollection tc = new TreeCollection();
    tc.insert(1);
    Iterator it = tc.iterator();
    it.next();
    assertThrows(NoSuchElementException.class, () -> it.next());
  }
}