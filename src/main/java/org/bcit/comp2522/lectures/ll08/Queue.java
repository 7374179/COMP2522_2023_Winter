package org.bcit.comp2522.lectures.ll08;

public class Queue<T> {
  Node<T> head;
  Node<T> temp = new Node<T>(head.value);

  public void push(T val) {
    if(head==null){
      head=temp;
    }else{
      temp.next = head;
      head=temp;
    }
    head.value = val;
    // TODO
  }

  public T pop() {
    if(head.next==null){
      return head.value;
    }
    Node<T> curr = head.next;
    Node<T> last = head;
    while(curr.next!=null){
      last=curr;
      curr=curr.next;
    }
    last.next = null;
    return curr.value;
    // TODO
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
