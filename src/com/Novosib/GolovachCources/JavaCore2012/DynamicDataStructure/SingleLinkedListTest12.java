package com.Novosib.GolovachCources.JavaCore2012.DynamicDataStructure;

/**
 * Created by AdminAccount on 22.11.2015.
 * Разные способы создания односвязного списка: два рекурсивных (c головы и с хвоста) и два итеративных (c головы и с хвоста)
 */
public class SingleLinkedListTest12 {
    public static void main(String[] args) {
        Node tailA = generateIter0(9);
        Node tailB = generateIter1(9);
        Node tail0 = generateRec0(9);
        Node tail1 = new Node(9, null); generateRec1(tail1);

        System.out.println(toStringIter(tailA));
        System.out.println(toStringIter(tailB));
        System.out.println(toStringRec(tail0));
        System.out.println(toStringRec(tail1));
    }

    public static Node generateIter0(int max){//Итеративная генерация списка с "головы"
        Node result = null;
        for (int k = 0; k <= max; k++){
            result = new Node(k, result);
        }
        return result;
    }

    public static Node generateIter1(int max){//Итеративная генерация списка с "хвоста"
        Node tail = new Node(max, null);
        Node head = tail;
        for (int k = max; k > 0; k--){
            head.next = new Node(k - 1, null);
            head = head.next;
        }
        return tail;
    }

    public static Node generateRec0(int value){//Рекурсивная генерация списка с "головы"
        if(value >= 0) {
            return new Node(value, generateRec0(value - 1));
        }
        else {
            return null;
        }
    }

    public static void generateRec1(Node node){//Рекурсивная генерация списка с "хвоста"
        if(node.value > 0){
            node.next = new Node(node.value - 1, null);
            generateRec1(node.next);
        }
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
