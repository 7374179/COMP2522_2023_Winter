package src.main.java.org.bcit.midterm.mysolution;

import java.util.Iterator;

// 1. The hasNext() method in TODO 2 returns a comparison of n with current.n,
//  but I did not define n in the class and current is not initialized.
//  This will cause a compilation error.
// 2. The next() method in TODO 2 returns a String, but the elements
//  in the Advanced_02_Node class are defined as a String and an int.
//  My method should return an element of the same type as the elements
//  in the Advanced_02_Node class.

public class Advanced_02_Iterator implements Iterator<Advanced_02_Node> {
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

  // TODO 3: Create an iterator that proceeds backwards through the Nodes
  // as if it were a LinkedList. Note that you do not need to actually
  // CONFIRM that it is a linked list, just act as if it were true.
  private Advanced_02_Node current;
    private boolean isForward;

    public Advanced_02_Iterator(Advanced_02_Node start, boolean isForward) {
        this.current = start;
        this.isForward = isForward;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Advanced_02_Node next() {
        Advanced_02_Node node = current;
        if (isForward) {
            current = current.next;
        } else {
            current = current.prev;
        }
        return node;
    }
}

