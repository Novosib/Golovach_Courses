package com.Novosib;

/**
 * Created by AdminAccount on 24.11.2015.
 */
public class DNode {
    int value;
    DNode prev;
    DNode next;

    DNode(int value, DNode prev, DNode next){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
