package org.bcit.comp2522.lectures.ll08;

public class KVPair<T> {
  String key;
  T value;

  public KVPair (String key, T value) {
    this.key = key;
    this.value = value;
  }

  public static void main(String[] args) {
    KVPair kvPair = new KVPair("Hello", "World");
    System.out.format("Key: %s; Value: %s\n", kvPair.key, kvPair.value.toString());
    // kvPair.value = 1;
    // System.out.format("Key: %s; Value: %s\n", kvPair.key, kvPair.value.toString());
    // kvPair.value = "World";
    // System.out.format("Key: %s; Value: %d\n", kvPair.key, kvPair.value);
  }
}