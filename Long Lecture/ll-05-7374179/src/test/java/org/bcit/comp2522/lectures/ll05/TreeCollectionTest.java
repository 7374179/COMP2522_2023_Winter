package org.bcit.comp2522.lectures.ll05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TreeCollectionTest {
  TreeCollection tc;

  @BeforeAll
  void setup() {
    tc = new TreeCollection();
    tc.insert(5);
    tc.insert(4);
    tc.insert(6);
    tc.insert(2);
    tc.insert(3);
    tc.insert(1);
  }

  @Test
  void structureTest() {
    assertEquals(5, tc.root.value);
    assertEquals(4, tc.root.left.value);
    assertEquals(6, tc.root.right.value);
    assertEquals(2, tc.root.left.left.value);
    assertEquals(1, tc.root.left.left.left.value);
    assertEquals(3, tc.root.left.left.right.value);
  }

  @Test
  void orderTest() {
    TreeCollection.TCIterator i = (TreeCollection.TCIterator) tc.iterator();
    int[] expected = {5, 4, 2, 1, 3, 6};
    ArrayList<TreeCollection.Node> order = i.DFSOrder();
    int[] actual = order.stream().mapToInt(n -> n.value).toArray();
    assertArrayEquals(expected, actual);
  }

  @Test
  void testRoot() {
    Iterator i = tc.iterator();
    assertTrue(i.hasNext());
    assertEquals(5, (int) i.next());
  }

  @Test
  void testFirstLeftNode() {
    Iterator i = tc.iterator();
    i.next();
    assertTrue(i.hasNext());
    assertEquals(4, (int) i.next());
  }


}