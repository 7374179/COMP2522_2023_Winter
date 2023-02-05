package ca.bcit.comp2522.labs.lab05;

import java.util.Iterator;


public class TreeCollection implements Iterable {

  Node node;
  TCIterator tcI = new TCIterator(null);


  //Node를 삽입하는 함수
  public Node insert(Node node, String newData) {
    if (node == null) {
//      node = new Node();
//      tcI.setNode(node, newData, null, null);
      return new Node(newData);
    }
    else if (node.data.compareTo(newData) > 0) {
      node.left = insert(node.left, newData);
    } else {
      node.right = insert(node.right, newData);
    }
    return node;
  }

//  public Node insert(Node node, String newData) {
//    // Base Case: root is null or not
//    if (node == null) {
//      // Insert the new data, if root is null.
//      node = new Node(newData);
//      // return the current root to his sub tree
//      return node;
//    }
//    // Here checking for root data is greater or equal to newData or not
//    else if (node.data.compareTo(newData)>0) {
//      // if current root data is greater than the new data then now process the left sub-tree
//      node = new Node(newData);
//      node.left = node;
//      return node;
//    } else {
//      // if current root data is less than the new data then now process the right sub-tree
//      node = new Node(newData);
//      node.right = node;
//
//      return node;
//    }
////    return node;
//  }


  @Override
  public Iterator iterator() {
    return new TCIterator();
  }
}
