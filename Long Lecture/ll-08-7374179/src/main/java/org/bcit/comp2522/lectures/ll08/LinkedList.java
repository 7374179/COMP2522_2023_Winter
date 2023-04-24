package org.bcit.comp2522.lectures.ll08;

public class LinkedList <T>{
  Node<T> head;

  void add(T val){
    Node<T> temp = new Node<T>(val);
    if(head==null){
      head=temp;
    }else{
      Node<T> curr = head;
      while(curr.next!=null){
        curr=curr.next;
      }
      curr.next = temp;
    }
  }
}
