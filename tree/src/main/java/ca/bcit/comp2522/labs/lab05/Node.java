package ca.bcit.comp2522.labs.lab05;

public class Node {
//    public Node root;
  public String data;
  public Node left;
  public Node right;

  /* 생성자 */

  public Node() {
  }

  public Node(String data) {
    this.data = data;
  }

  public Node(String data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }


}


