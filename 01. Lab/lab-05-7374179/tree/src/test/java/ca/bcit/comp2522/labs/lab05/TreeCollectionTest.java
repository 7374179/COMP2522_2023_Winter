package ca.bcit.comp2522.labs.lab05;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
class TreeCollectionTest {

  @Test
  void rootTest() {
    TreeCollection tc = new TreeCollection();
    tc.insert(5);
    tc.insert(4);
    tc.insert(6);
    tc.insert(2);
    tc.insert(3);
    tc.insert(1);

    Iterator it = tc.iterator();
    int[] order = {5, 4, 2, 1, 3, 6};
    assertEquals(1, tc.root.left.left.left.value);
  }

  @Test
  void rootNullTest(){
    TreeCollection tc = new TreeCollection();
    assertEquals(null, tc.root);
  }

  @Test
  void rootValueTest(){
    TreeCollection tc = new TreeCollection();
    tc.insert(5);
    tc.insert(4);
    tc.insert(6);
    tc.insert(2);
    tc.insert(3);
    tc.insert(1);
    assertEquals(5, tc.root.value);
  }

  @Test
  void rightValueTest(){
    TreeCollection tc = new TreeCollection();
    tc.insert(5);
    tc.insert(4);
    tc.insert(6);
    tc.insert(2);
    tc.insert(3);
    tc.insert(1);
    assertEquals(6, tc.root.right.value);
  }

}