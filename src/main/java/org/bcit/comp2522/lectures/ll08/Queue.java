package org.bcit.comp2522.lectures.ll08;

public class Queue<T> {
  Node<T> head;

  public void push(T val) {
    // TODO
  }

  public T pop() {
    // TODO
    return null;
  }

  public void print() {
    Node<T> curr = head;
    System.out.println(curr.value.toString());
    while(curr.next != null) {
      curr = curr.next;
      System.out.println(curr.value.toString());
    }
  }

  public static void main(String[] args) {
    Queue<String> queue = new Queue<>();
    queue.push("1");
    queue.push("2");
    queue.push("3");
    queue.print();
    System.out.println("-------");
    queue.pop();
    queue.print();
  }
}
