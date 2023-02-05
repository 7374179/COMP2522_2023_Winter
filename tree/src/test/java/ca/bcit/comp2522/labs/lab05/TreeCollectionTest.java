package ca.bcit.comp2522.labs.lab05;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
class TreeCollectionTest {

  Node node=null;

  @Test
  void TestExample() {
    TreeCollection tc = new TreeCollection();
    tc.insert(node, "F");
    tc.insert(node,"E");
    tc.insert(node,"A");
    tc.insert(node,"D");
    tc.insert(node,"G");
    tc.insert(node,"H");
//    node = tc.insert(node, "F");
//    node =tc.insert(node,"E");
//    node =tc.insert(node,"A");
//    node =tc.insert(node,"D");
//    node =tc.insert(node,"G");
//    node =tc.insert(node,"H");
    Iterator it = tc.iterator();
    String[] order = {"F", "E", "A", "D", "G", "H"};
    int i = 0;
    Node current;
//    Node current=node;
    while (it.hasNext()) {
      current = (Node)it.next();
      assertEquals(order[i], current.data);
      i++;
    }
  }
}