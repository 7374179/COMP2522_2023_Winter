package ca.bcit.comp2522.labs.lab05;

import java.util.Iterator;


public class TreeCollection implements Iterable {

  Node root;
  TCIterator tcI = new TCIterator(null);


  //Node를 삽입하는 함수
  public void insert(int i) {
    Node temp = new Node(i);

    if (root == null) {
      root = temp;
      return;
    }

    Node current = root;
    while (current != null) {
      if (current.left == null && temp.value <= current.value) {
        current.left = temp;
        return;
      } else if (current.right == null && temp.value > current.value) {
        current.right = temp;
        return;
      } else if (temp.value <= current.value) {
        current = current.left;
      } else if (temp.value > current.value) {
        current = current.right;
      }
    }
  }

  @Override
  public Iterator iterator() {
    return new TCIterator(root);
  }
}