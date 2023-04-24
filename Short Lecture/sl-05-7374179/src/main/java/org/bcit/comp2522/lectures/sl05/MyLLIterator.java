package org.bcit.comp2522.lectures.sl05;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyLLIterator implements Iterator {
  Node current;

  public MyLLIterator() {};

  public MyLLIterator(Node n) {
    this.current = n;
  }

  public boolean hasNext() {
    if (current == null) {
      return false;
    }
    return  true;
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Object next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Node temp = current;
    current = current.next;
    return temp;
  }

}
