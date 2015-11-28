package com.Novosib;

/**
 * Created by AdminAccount on 22.11.2015.
 */
public class SingleLinkedListTest1 {
    public static void main(String[] args) {
        Node node4 = new Node(0, null);
        Node node2 = new Node(1, node4);
        Node node1 = new Node(2, node2);
        Node node0 = new Node(3, node1);

        Node ref = node0;
        while (ref != null){
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
