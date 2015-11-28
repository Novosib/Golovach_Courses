package com.Novosib;

/**
 * Created by AdminAccount on 22.11.2015.
 * Генерация списка от первого элемента к последнему
 */
public class SingleLinkedListTest10 {
    public static void main(String[] args) {
        Node tail = null;//Хвост
        for (int k = 0; k < 10; k++){
            tail = new Node(k, tail);
        }
        Node ref = tail;
        while (ref != null){
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
