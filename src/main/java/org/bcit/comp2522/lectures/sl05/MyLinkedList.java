package org.bcit.comp2522.lectures.sl05;

import java.util.Iterator;

public class MyLinkedList implements Iterable {
  Node head;
  public void insert(String s) {
    // TODO: use iterator to solve this
  }

  /**
   * Returns an iterator over elements of type {@code T}.
   *
   * @return an Iterator.
   */
  @Override
  public Iterator iterator() {
    return new MyLLIterator(head);
  }
}