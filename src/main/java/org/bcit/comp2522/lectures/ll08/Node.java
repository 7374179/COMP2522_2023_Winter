package org.bcit.comp2522.lectures.ll08;

public class Node <T> {
  T value;
  Node next;

  public Node(T val){
    this.value = val;
  }

  public static void main(String[] args){
    Node<Integer> node = new Node(1);
    System.out.println(node.value.toString());
  }
}
