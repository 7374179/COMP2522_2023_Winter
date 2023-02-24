package org.bcit.comp2522.lectures.ll08;

public class MyHashTable<K, V> {
  MyKVPair<K ,V>[] table;
  public MyHashTable() {
    table = new MyKVPair[8];
  }

  int hash(Object o) {
    // TODO
    return 1;
  }

  V get(K key) {
    // TODO
    return null;
  }

  void add(K key, V value) {
    // TODO
  }

  void add2(K key, V value) {
    // TODO
  }

  @Override
  public String toString() {
    String acc = "MyKVDictionary: \n";
    for (int i = 0; i < table.length; i++) {
      MyKVPair<K, V> kvPair = table[i];
      if (kvPair != null) {
        acc = acc + String.format("Key: %s; Value: %s\n", kvPair.key, kvPair.value);
      } else {
        acc = acc + "Null \n";
      }
    }
    return acc;
  }
  public void print() {
    System.out.format("%s\n------------\n",this.toString());
  }

  public static void main(String[] args) {
    MyHashTable<Integer, String> hashTable = new MyHashTable<>();
    hashTable.add(1, "1");
    hashTable.print();
    hashTable.add(2, "2");
    hashTable.print();
    hashTable.add2(3, "3");
    hashTable.add2(4, "4");
    hashTable.add2(5, "5");
    hashTable.add2(6, "6");
    hashTable.add2(7, "7");
    hashTable.add2(8, "8");
    hashTable.add2(9, "9");
    hashTable.add2(16, "10");
    hashTable.add2(32, "11");
    hashTable.print();
    System.out.format("h(8): %d, h(16): %d, h(32): %d\n", hashTable.hash(8), hashTable.hash(16),hashTable.hash(32));
    System.out.format("\nFound %s!", hashTable.get(16).toString());
    System.out.format("\nFound %s!", hashTable.get(7).toString());
  }
}
