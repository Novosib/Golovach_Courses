package com.Novosib.GolovachCources.JavaCore2012.DynamicDataStructure;

/**
 * Created by AdminAccount on 22.11.2015.
 */
public class SingleLinkedListTest11 {
    public static void main(String[] args) {
        Node tail = null;//Хвост
        for (int k = 0; k < 10; k++){
            tail = new Node(k, tail);
        }
        System.out.println(toStringIter(tail));
        System.out.println(toStringRec(tail));
    }

    public static String toStringIter(Node ref){
        String result = "";
        while (ref != null){
            result += "(" + ref.value + ")->";
            ref = ref.next;
        }
        return result + "null";
    }

    public static String toStringRec(Node ref){
        if(ref == null) {
            return "null";
        } else {
            return "(" + ref.value + ")->" + toStringRec(ref.next);
        }
    }
}
