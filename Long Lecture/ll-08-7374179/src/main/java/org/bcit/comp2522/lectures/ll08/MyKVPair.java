package org.bcit.comp2522.lectures.ll08;

public class MyKVPair<K, V> {
  K key;
  V value;

  public MyKVPair (K key, V value) {
    this.key = key;
    this.value = value;
  }

  public static void main(String[] args) {
    MyKVPair kvPair = new MyKVPair("Hello", "World");
    System.out.format("Key: %s; Value: %s\n", kvPair.key.toString(), kvPair.value.toString());
    // kvPair.value = 1;
    // System.out.format("Key: %s; Value: %s\n", kvPair.key, kvPair.value.toString());
    // kvPair.value = "World";
    // System.out.format("Key: %s; Value: %d\n", kvPair.key, kvPair.value);
  }
}