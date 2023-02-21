# Lab-08

This week is a light post-midterm lab focused on JSON parsing and File I/O, with a tiny intro to generics. It's designed to be done with your project group, but it's recommended to make sure you can do everything on the lab on your own as well. 

## TODO 1: Go through the JSON parsing examples on GeeksForGeeks
JSON is a common object-oriented data standard. You should be using it for the persistent data structures in your game. [Start by going through the JSON examples on GeeksForGeeks](https://www.geeksforgeeks.org/parse-json-java/). You'll see that you need to do File I/O, which we briefly touched on before the midterm. Use the examples from class and from the GeeksForGeeks tutorial and become comfortable with reading and writing JSON to files.

## TODO 2: Make a generic data structure and write it to JSON.
We'll be covering this in lecture, so you can simply copy-paste the code below and play around with it. Start by creating a key-value pair using generics:

```.java
public class KVPair<T> {
  String key;
  T value;
  
  public KVPair (String key, T value) {
    this.key = key;
    this.value = value;
  }
}
```

The `T` is a type variable. That means that the value can be any object type. See how it works by playing with this `main` method and commenting/uncommenting different lines to see what breaks.

```.java
public static void main(String[] args) {
    KVPair kvPair = new KVPair("Hello", "World");
    System.out.format("Key: %s; Value: %s\n", kvPair.key, kvPair.value.toString());
    // kvPair.value = 1;
    // System.out.format("Key: %s; Value: %s\n", kvPair.key, kvPair.value.toString());
    // kvPair.value = "World";
    // System.out.format("Key: %s; Value: %d\n", kvPair.key, kvPair.value);
  }
```

Now make a data structure that holds multiple KVPairs.

```.java
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
    System.out.format("%s\n",this.toString());
  }
```

You can see that this is basically just a wrapper for an `ArrayList` with some logic for accessing the contents of a `KVPair`. You can test it by creating a `main` method and adding things to the data structure:

```.java
public static void main(String[] args) {
    MyDictionary dictionary = new MyDictionary();
    dictionary.add("Hello", "World");
    dictionary.add("Number", 1);
    dictionary.print();
    System.out.println(dictionary.get("Number"));
    System.out.println(dictionary.get("Numba"));
}
```

Now you have enough to create a rudimentry `JSON`-like object. If a `MyDictionary` can contain either `MyDictionary` or an array of `KVPair`, it's effectively just a `JSON` structure in Java memory. Now try writing out your `MyDictionary` as a `JSON` file. You can essentially just modify the `print` method to instead build a string  of key-value pairs. If you want to challenge yourself (this is not required) you can try to (1) deal with multiple levels of nesting; and (2) parse from a JSON file into the `MyDictionary` structure.

## TODO 3 (Project): Plan your JSON data structure for your project
Along with your team, start to design the data structure that you'll need for your project. It's OK for it to be a draft, but have something that can be written in and out to a real file to show Paul for next week. Make sure to include everything that is important for your program state. For example, the position of every enemy, or the tiles on your game board (if you have those kinds of projects).
