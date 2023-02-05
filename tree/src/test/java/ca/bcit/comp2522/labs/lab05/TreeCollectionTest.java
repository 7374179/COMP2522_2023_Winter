package ca.bcit.comp2522.labs.lab05;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
class TreeCollectionTest {

  Node node=null;

  @Test
  void TestExample() {
    TreeCollection tc = new TreeCollection();
    tc.insert(5);
    tc.insert(4);
    tc.insert(6);
    tc.insert(2);
    tc.insert(3);
    tc.insert(1);
//    node = tc.insert(node, "F");
//    node =tc.insert(node,"E");
//    node =tc.insert(node,"A");
//    node =tc.insert(node,"D");
//    node =tc.insert(node,"G");
//    node =tc.insert(node,"H");
    Iterator it = tc.iterator();
    String[] order = {5, 4, 2, 1, 3, 6};
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