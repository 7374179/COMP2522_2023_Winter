package ca.bcit.comp2522.labs.lab05;

import java.util.ArrayList;

public class MyDictionary {
  ArrayList<KVPair> kvPairs;

  public MyDictionary() {
    this.kvPairs = new ArrayList<KVPair>();
  }

  public <T> void add(String key, T value) {
    KVPair<T> kvPair = new KVPair<T>(key, value);
    kvPairs.add(kvPair);
  }

  @Override
  public String toString() {
    String acc = "MyDictionary: \n";
    for (KVPair kvPair : kvPairs) {
      acc = acc + String.format("Key: %s; Value: %s\n", kvPair.key, kvPair.value);
    }
    return acc;
  }

  public ArrayList<String> keys() {
    ArrayList<String> keylist = new ArrayList<String>();
    for (KVPair kvPair : kvPairs) {
      keylist.add(kvPair.key);
    }
    return keylist;
  }

  public Object get(String key) {
    for (KVPair kvPair : kvPairs) {
      if (kvPair.key == key) {
        return kvPair.value;
      }
    }
    return null;
  }

  public void print() {
    System.out.format("%s\n", this.toString());
  }

  public static void main(String[] args) {
    MyDictionary dictionary = new MyDictionary();
    dictionary.add("Hello", "World");
    dictionary.add("Number", 1);
    dictionary.print();
    System.out.println(dictionary.get("Number"));
    System.out.println(dictionary.get("Numba"));
  }
}
