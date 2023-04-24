package org.bcit.comp2522.lectures.ll08;

import java.util.ArrayList;
import java.util.List;

public class MyKVDictionary<K, V> {
  private List<MyKVPair<K, V>> kvPairs;

  public MyKVDictionary() {
    this.kvPairs = new ArrayList<MyKVPair<K, V>>();
  }

  public void add(K key, V value) {
    MyKVPair<K, V> kvPair = new MyKVPair<K, V>(key, value);
    kvPairs.add(kvPair);
  }

  @Override
  public String toString() {
    String acc = "MyKVDictionary: \n";
    for (MyKVPair kvPair : kvPairs) {
      acc = acc + String.format("Key: %s; Value: %s\n", kvPair.key, kvPair.value);
    }
    return acc;
  }

  public ArrayList<K> keys() {
    ArrayList<K> keylist = new ArrayList<K>();
    for (MyKVPair<K, V> kvPair : kvPairs) {
      keylist.add(kvPair.key);
    }
    return keylist;
  }

  public V get(K key) {
    for (MyKVPair<K, V> kvPair : kvPairs) {
      if (kvPair.key == key) {
        return kvPair.value;
      }
    }
    return null;
  }

  public void print() {
    System.out.format("%s\n",this.toString());
  }

  public static void main(String[] args) {
    MyKVDictionary<String, String> dictionary = new MyKVDictionary<String, String>();
    dictionary.add("Hello", "World");
    dictionary.print();
  }
}