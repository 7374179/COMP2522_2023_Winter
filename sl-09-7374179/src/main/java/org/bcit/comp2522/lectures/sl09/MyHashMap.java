package org.bcit.comp2522.lectures.sl09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMap <K, V> implements Iterable {
  MyLinkedList<K, V>[] table;

  MyHashMap() {
    this.table = new MyLinkedList[8];
  }

  MyHashMap(int length) {
    this.table = new MyLinkedList[length];
  }


  void add(K key, V value) {
    // TODO
//    int index = hash(key);
//    table[index].add(key, value);
    int index = hash(key);
    if (table[index] == null) {
      table[index] = new MyLinkedList<K, V>();
    }
    table[index].add(key, value);
  }

  V get(K key) {
    // TODO
    int index = hash(key);
    return table[index].get(key);
  }

  int hash(K key) {
    return key.hashCode() % table.length;
  }

  void rehash() {
    MyLinkedList<K, V>[] temp = new MyLinkedList[table.length * 2];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = new MyLinkedList<K, V>();
    }

    Iterator it = this.iterator();
  }

  @Override
  public Iterator iterator() {
    return new MyHashMapIterator();
  }

  private class MyHashMapIterator implements Iterator {
    ArrayList<Node<K, V>> allnodes;
    Iterator allnodesIterator;

    MyHashMapIterator() {
      allnodes = new ArrayList();
      for (int i = 0; i < table.length; i++) {
        MyLinkedList<K, V> ll = table[i];
        Iterator lli = ll.iterator();
        while (lli.hasNext()) {
          allnodes.add((Node<K, V>) lli.next());
        }
      }
      allnodesIterator = allnodes.iterator();
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
      return allnodesIterator.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() throws NoSuchElementException {
      return allnodesIterator.next();
    }
  }
}