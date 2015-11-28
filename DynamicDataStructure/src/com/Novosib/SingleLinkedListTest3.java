package com.Novosib;

/**
 * Created by AdminAccount on 22.11.2015.
 */
public class SingleLinkedListTest3 {
    public static void main(String[] args) {
        Node node0 = node(0, node(1, node(2, node(3, null))));

        Node ref = node0;
        while (ref != null){
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }

    static Node node(int value, Node next){
        return new Node(value, next);
    }
}
