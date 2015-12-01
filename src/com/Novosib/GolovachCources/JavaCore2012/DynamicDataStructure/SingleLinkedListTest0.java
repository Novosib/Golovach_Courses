package com.Novosib.GolovachCources.JavaCore2012.DynamicDataStructure;

/**
 * Created by AdminAccount on 22.11.2015.
 */
public class SingleLinkedListTest0 {
    public static void main(String[] args) {
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node ref = node0;
        while (ref != null){
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}