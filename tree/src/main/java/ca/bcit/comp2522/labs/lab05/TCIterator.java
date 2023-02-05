package ca.bcit.comp2522.labs.lab05;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TCIterator implements Iterator {
//  Node root;

  Node current;

  public TCIterator() {
  }

  public TCIterator(Node n) {
    this.current = n;
  }

  public boolean hasNext() {
    if (current == null) {
      return false;
    }
    return true;
  }

  @Override
//  public Node next() {
////    if (!hasNext()) {
////      throw new NoSuchElementException();
////    }
//    while (current != null) {
//      current = current.left;
//    }
//    Node temp = current;
//    current = current.right;
//    return temp;
//  }
  public Node next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    while (current != null) {
      if (current.left == null) {
        break;
      }
      current = current.left;
    }
//    Node temp = current;
//    current = current.right;
    return current;
  }

//  public Node next() {
//    if (!hasNext()) {
//      throw new NoSuchElementException();
//    }
//    while (current != null) {
//      if (current.left == null) {
//        break;
//      }
//      current = current.left;
//    }
//    Node temp = current;
//    current = current.right;
//    return temp;
//  }


  void setNode(Node node, String data, Node left, Node right) {
    Node newNode = new Node(data);
    node = newNode;
    node.left = left;
    node.right = right;

  }


//  void MorrisTraversal(Node root) {
//    Node current, pre;
//
//    if (root == null)
//      return;
//
//    current = root;
//    while (current != null)
//    {
//      if (current.left == null)
//      {
//        System.out.print(current.data + " ");
//        current = current.right;
//      }
//      else {
//                /* Find the inorder
//                    predecessor of current
//                 */
//        pre = current.left;
//        while (pre.right != null
//            && pre.right != current)
//          pre = pre.right;
//
//                /* Make current as right
//                   child of its
//                 * inorder predecessor */
//        if (pre.right == null) {
//          pre.right = current;
//          current = current.left;
//        }
//
//                /* Revert the changes made
//                   in the 'if' part
//                   to restore the original
//                   tree i.e., fix
//                   the right child of predecessor*/
//        else
//        {
//          pre.right = null;
//          System.out.print(current.data + " ");
//          current = current.right;
//        } /* End of if condition pre->right == NULL
//         */
//
//      } /* End of if condition current->left == NULL*/
//
//    } /* End of while */
//  }

}
