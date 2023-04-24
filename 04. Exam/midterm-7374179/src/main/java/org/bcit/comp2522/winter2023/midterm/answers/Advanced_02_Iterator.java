package org.bcit.comp2522.winter2023.midterm.answers;

import java.util.Iterator;

public class Advanced_02_Iterator implements Iterable {
  // Advanced Question 02 (20 points, 4 TODOs)
  // Idea: tests your ability to create and use iterators.

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Advanced_02_myClass. Name them something
  // useful, other than "myClass", that is just an example.

  // TODO 1: Create a new class called Advanced_02_Node. It should
  // have three fields:
  // - label: string
  // - value: int
  // - next: Node

  // TODO 2: Create an iterator that proceeds forwards through the Nodes
  // as if it were a LinkedList. Note that you do not need to actually
  // CONFIRM that it is a linked list, just act as if it were true.
  Advanced_02_Node current;
  public Advanced_02_Iterator(int n) {
    current.value = n;
  }
  public boolean hasNext() {
    return n < current.n;
  }
  public String next() {

    return 0;
  }
  @Override
  public Iterator iterator() {

    return null;
  }

  // TODO 3: Create an iterator that proceeds backwards through the Nodes
  // as if it were a LinkedList. Note that you do not need to actually
  // CONFIRM that it is a linked list, just act as if it were true.
}
