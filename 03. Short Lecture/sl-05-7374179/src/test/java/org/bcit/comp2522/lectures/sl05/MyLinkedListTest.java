package org.bcit.comp2522.lectures.sl05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

  @Test
  void insert() {
    String[] instrs = {"A", "B", "C"};
    ArrayList outstrs = new ArrayList<String>();
    MyLinkedList ll = new MyLinkedList();
    ll.insert("A");
    ll.insert("B");
    ll.insert("C");
    ll.forEach((n) -> outstrs.add(((Node) n).value));
    assertArrayEquals(instrs, outstrs.toArray());
  }
}