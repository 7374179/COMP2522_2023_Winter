package org.bcit.comp2522.lectures.ll08;

import java.util.ArrayList;
import java.util.List;

public  class Dictionary<T> {
  private List<KVPair<T>> kvPairs;

  public Dictionary() {
    this.kvPairs = new ArrayList<KVPair<T>>();
  }

  public void add(String key, T value) throws DuplicateKeyException {
    for(KVPair<T> kvPair : kvPairs){
      if(kvPair.key.equals(key)){
        throw new DuplicateKeyException();
      }
    }
    KVPair<T> kvPair = new KVPair<T>(key, value);
    kvPairs.add(kvPair);
  }

  @Override
  public String toString() {
    String acc = "Dictionary: \n";
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

  public T get(String key) {
    for (KVPair<T> kvPair : kvPairs) {
      if (kvPair.key == key) {
        return kvPair.value;
      }
    }
    return null;
  }

  public void print() {
    System.out.format("%s\n",this.toString());
  }

  public static void main(String[] args) throws DuplicateKeyException {
    Dictionary<String> dictionary = new Dictionary<String>();
    dictionary.add("Hello", "World");
    dictionary.print();
  }
}