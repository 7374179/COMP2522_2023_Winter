package org.bcit.comp2522.lectures.sl09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<K, V> {
  Node<K, V> head;

  void add(K key, V value) {
    Node<K, V> temp = new Node<K, V>(key, value);
    if (head == null) {
      head = temp;
    } else {
      Node<K, V> curr = head;
      while(curr.next != null) {
        curr = curr.next;
      }
      curr.next = temp;
    }
  }

  V get(K key) {
    // TODO
    Iterator it = iterator();
    Node<K,V>node = (Node) it.next();
    if(node.key == key){
      return node.value;
    }
    return null;
  }

  public Iterator iterator() {
    return new MyLinkedListIterator();
  }

  private class MyLinkedListIterator implements Iterator {
    ArrayList<Node<K, V>> list;
    int index;
    MyLinkedListIterator() {
      index = 0;
      if (head != null) {
        Node<K, V> curr = head;
        list = new ArrayList<Node<K, V>>();
        list.add(head);
        while(curr.next != null) {
          list.add(curr);
          curr = curr.next;
        }
      }
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
      if (index >= list.size()) {
        return false;
      }
      return true;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
      if (list == null || index >= list.size()) {
        throw new NoSuchElementException();
      }
      index++;
      return list.get(index - 1);
    }
  }
}