package com.Novosib.GolovachCources.JavaCore2012.DynamicDataStructure;

/**
 * Created by AdminAccount on 24.11.2015.
 */
public class DoubleLinkedListMethods {
    public static void main(String[] args) {
        DNode tail = new DNode(3, null, null);
        generateRec(tail); printFromHead(tail);
        addIter(tail, -1); printFromHead(tail);
        addRec(tail, -2); printFromHead(tail);
        addIter(tail, 6, 10); printFromHead(tail);
        addRec(tail, 7, 20); printFromHead(tail);
        removeIter(tail); printFromHead(tail);
        removeRec(tail); printFromHead(tail);
        removeIter(tail, 5); printFromHead(tail);
        removeRec(tail, 1); printFromHead(tail);
    }

    public static void print(DNode tail){
        printFromTail(tail);
        printFromHead(tail);
    }

    public static void printFromTail(DNode tail){
        System.out.println(toStringFromTail(tail));
    }
    public static String toStringFromTail(DNode ref){
        String result = "";
        while (ref != null){
            result += "(" + ref.value + ")->";
            ref = ref.next;
        }
        return result + "null";
    }
    public static void printFromHead(DNode tail){
        System.out.println(toStringFromHead(tail));
    }
    public static String toStringFromHead(DNode ref){
        while (ref.next != null){
            ref = ref.next;
        }
        String result = "";
        while (ref != null){
            result += "<-(" + ref.value + ")";
            ref = ref.prev;
        }
        return "null" + result;
    }

    public static void generateRec(DNode node){//Рекурсивная генерация списка с "хвоста"
        if(node.value > 0){
            node.next = new DNode(node.value - 1, node, null);
            generateRec(node.next);
        }
    }

    //Итеративный подсчет количества элементов переданного списка
    public static int sizeIter(DNode node){
        int size = 0;
        while (node != null){
            size++;
            node = node.next;
        }
        return size;
    }



    //Методы работы со списком

    //Итеративное добавление элемента в конец списка (в голову)
    public static void addIter(DNode node, int value){
        while (node.next != null){
            node = node.next;
        }
        node.next = new DNode(value, node, null);
    }

    //Рекурсивное добавление элемента в конец списка (в голову)
    public static void addRec(DNode node, int value){
        if (node.next == null) node.next = new DNode(value, node, null);
        else addRec(node.next, value);
    }

    //Итеративное добавление элемента на i-ую позицию
    public static void addIter(DNode node, int index, int value){
        if (index == 0) {
            System.out.println("addIter(node, index, value): вставка в 0 позицию невозможна");
        }else if(index > sizeIter(node)){
            System.out.println("addIter(node, index, value): вставка невозможна, т.к. индекс больше длины списка");
        }else {
            int k = 1;
            while (k < index){
                node = node.next;
                k++;
            }
            node.next = new DNode(value, node, node.next);
            if(node.next.next != null) node.next.next.prev = node.next;
        }
    }

    //Рекурсивное добавление элемента на i-ую позицию
    public static void addRec(DNode node, int index, int value){
        if (index == 0) {
            System.out.println("addRec(node, index, value): вставка в 0 позицию невозможна");
        }else if(index > sizeIter(node)){
            System.out.println("addRec(node, index, value): вставка невозможна, т.к. индекс больше длины списка");
        }else if(index == 1){
            node.next = new DNode(value, node, node.next);
            if(node.next.next != null) node.next.next.prev = node.next;
        } else addRec(node.next, index - 1, value);

    }

    //Итеративное удаление элемента из конца списка (из головы)
    public static void removeIter(DNode node){
        if (node.next == null || node == null) return;
        while (node.next.next != null){
            node = node.next;
        }
        node.next = null;
    }

    //Рекурсивное удаление элемента из конца списка (из головы)
    public static void removeRec(DNode node){
        if (node.next == null || node == null) return;
        if (node.next.next == null) {
            node.next = null;
        }else {
            removeRec(node.next);
        }
    }

    //Итеративное удаление элемента из i-ой позиции
    public static void removeIter(DNode node, int index){
        if (index == 0) {
            System.out.println("removeIter(node, index): удаление из 0 позиции невозможно");
        }else if(index >= sizeIter(node)){
            System.out.println("removeIter(node, index): удаление невозможно, т.к. индекс больше длины списка");
        }else {
            int k = 1;
            while (k < index){
                node = node.next;
                k++;
            }
            if (node.next.next != null) node.next.next.prev = node;
            node.next = node.next.next;
        }
    }

    //Рекурсивное удаление элемента из i-ой позиции
    public static void removeRec(DNode node, int index){
        if (index == 0) {
            System.out.println("removeRec(node, index): удаление из 0 позиции невозможно");
        }else if(index >= sizeIter(node)){
            System.out.println("removeRec(node, index): удаление невозможно, т.к. индекс больше длины списка");
        }else if(index == 1){
            if (node.next.next != null) node.next.next.prev = node;
            node.next = node.next.next;
        } else removeRec(node.next, index - 1);

    }

}
