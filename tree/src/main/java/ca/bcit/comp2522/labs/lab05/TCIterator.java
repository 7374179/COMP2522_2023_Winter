package ca.bcit.comp2522.labs.lab05;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TCIterator implements Iterator {
//  Node root;

  Node root;
  ArrayList<Node> order;
  int index = 0;

  public TCIterator() {
  }

  public TCIterator(Node root) {
    this.root = root;
    this.order = DFSOrder();
  }

  public ArrayList<Node> DFSOrder() {
    ArrayList<Node> order = new ArrayList<Node>();

    if (root == null) return order;

    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node curr = stack.pop();
      order.add(curr);
      if (curr.right != null) stack.push(curr.right);
      if (curr.left != null) stack.push(curr.left);
    }
    return order;
  }

  @Override
  public boolean hasNext() {
    return index < order.size();
  }

  @Override
  public Object next() {
//            if (!hasNext()) {
//                throw NoSuchElementException();
//            }
    Node temp = order.get(index);
    index++;
    return temp.value;
  }
}


//  void setNode(Node node, String data, Node left, Node right) {
//    Node newNode = new Node(data);
//    node = newNode;
//    node.left = left;
//    node.right = right;
//  }

}
