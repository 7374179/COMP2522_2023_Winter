package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.ArrayList;
import java.util.List;

public class Advanced_02_MySolution {
//    This Java program named "Advanced_02_MySolution" creates a linked list of "Advanced_02_Node" objects
//    and uses two iterators, "forwardIterator" and "backwardIterator",
//    to traverse the list in forward and backward directions.
//    It then prints out the labels and values of each node in the list for both forward and backward traversals.
    public static void main(String[] args) {
        // Create a linked list of Advanced_02_Node objects
        Advanced_02_Node node1 = new Advanced_02_Node("Node 1", 1);
        Advanced_02_Node node2 = new Advanced_02_Node("Node 2", 2);
        Advanced_02_Node node3 = new Advanced_02_Node("Node 3", 3);
        node1.next = node2;
        node2.next = node3;

        // Use the forward iterator to iterate through the linked list
        Advanced_02_Iterator forwardIterator = new Advanced_02_Iterator(node1, true);
        List<Advanced_02_Node> forwardList = new ArrayList<>();
        while (forwardIterator.hasNext()) {
            forwardList.add(forwardIterator.next());
        }
        System.out.println("Forward traversal:");
        for (Advanced_02_Node node : forwardList) {
            System.out.println(node.label + ": " + node.value);
        }

        // Use the backward iterator to iterate through the linked list
        Advanced_02_Iterator backwardIterator = new Advanced_02_Iterator(node3, false);
        List<Advanced_02_Node> backwardList = new ArrayList<>();
        while (backwardIterator.hasNext()) {
            backwardList.add(backwardIterator.next());
        }
        System.out.println("Backward traversal:");
        for (Advanced_02_Node node : backwardList) {
            System.out.println(node.label + ": " + node.value);
        }
    }
}
