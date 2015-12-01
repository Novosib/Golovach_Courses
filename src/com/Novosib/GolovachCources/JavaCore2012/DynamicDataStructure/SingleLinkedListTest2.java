package com.Novosib.GolovachCources.JavaCore2012.DynamicDataStructure;

/**
 * Created by AdminAccount on 22.11.2015.
 */
public class SingleLinkedListTest2 {
    public static void main(String[] args) {
        Node node0 = new Node(0, new Node(1, new Node(2, new Node(3, null))));

        Node ref = node0;
        while (ref != null){
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
