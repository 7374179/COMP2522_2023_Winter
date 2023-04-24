package org.bcit.comp2522.lectures.sl09;

public class MyHashMap <K, V> {
  MyLinkedList<K, V>[] table;

  MyHashMap() {
    this.table = new MyLinkedList[8];
  }

  MyHashMap(int length) {
    this.table = new MyLinkedList[length];
  }

  void add(K key, V value) {
    // TODO
  }

  V get(K key) {
    // TODO
    return null;
  }

  int hash(K key) {
    return key.hashCode() % table.length;
  }

  void rehash() {
    // TODO
  }
}
