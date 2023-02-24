package org.bcit.comp2522.lectures.ll08;

public class Stack<T> {
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
    Stack<String> stack = new Stack<String>();
    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.print();
    System.out.println("-------");
    stack.pop();
    stack.print();
  }
}
