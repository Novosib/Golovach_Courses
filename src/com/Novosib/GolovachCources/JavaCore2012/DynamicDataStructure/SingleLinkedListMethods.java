package com.Novosib.GolovachCources.JavaCore2012.DynamicDataStructure;

/**
 * Created by AdminAccount on 22.11.2015.
 */
public class SingleLinkedListMethods {

    public static void main(String[] args) {
        Node tail = SingleLinkedListTest12.generateIter0(3); print(tail);
        addIter(tail, 10); print(tail);
        addRec(tail, 20); print(tail);
        removeIter(tail); print(tail);
        removeRec(tail); print(tail);
        addIter(tail, 1, -1); print(tail);
        removeIter(tail, 1); print(tail);
        addIter(tail, 1, -1); print(tail);
        removeRec(tail, 1); print(tail);


        System.out.println("Размер списка (итеративно)= " + sizeIter(tail));
        System.out.println("Размер списка (рекурсивно)= " + sizeRec(tail));

        System.out.println("Сумма элементов списка (итеративно)= " + sumIter(tail));
        System.out.println("Сумма элементов списка (рекурсивно)= " + sumRec(tail));

        System.out.println("Максимальный элемент списка (итеративно)= " + maxIter(tail));
        System.out.println("Максимальный элемент списка (рекурсивно)= " + maxRec(tail));

    }

    public static void print(Node tail){
        System.out.println(SingleLinkedListTest12.toStringIter(tail));
    }

    //Итеративный подсчет количества элементов переданного списка
    public static int sizeIter(Node node){
        int size = 0;
        while (node != null){
            size++;
            node = node.next;
        }
        return size;
    }

    //Рекурсивный подсчет количества элементов переданного списка
    public static int sizeRec(Node node){
        if (node.next == null) return 1;
        else{
            return 1 + sizeRec(node.next);
        }
    }

    //Итеративный подсчет суммы всех элементов переданного списка
    public static int sumIter(Node node){
        int sum = 0;
        while (node != null){
            sum += node.value;
            node = node.next;
        }
        return sum;
    }

    //Рекурсивный подсчет суммы всех элементов переданного списка
    public static int sumRec(Node node){
        if (node.next == null) return node.value;
        else{
            return node.value + sumRec(node.next);
        }
    }

    //Итеративный поиск максимального элемента в переданном списке
    public static int maxIter(Node node){
        int max = node.value;
        while (node != null){
            if(node.value > max) max = node.value;
            node = node.next;
        }
        return max;
    }

    //Рекурсивный поиск максимального элемента в переданном списке
    public static int maxRec(Node node){
        if (node.next == null) return node.value;
        else{
            int max = maxRec(node.next);
            if (node.value > max) return node.value;
            else return max;
        }
    }

    //Итеративное добавление элемента в конец списка (в голову)
    public static void addIter(Node node, int value){
        while (node.next != null){
            node = node.next;
        }
        node.next = new Node(value, null);
    }

    //Рекурсивное добавление элемента в конец списка (в голову)
    public static void addRec(Node node, int value){
        if (node.next == null) node.next = new Node(value, null);
        else addRec(node.next, value);
    }

    //Итеративное добавление элемента на i-ую позицию
    public static void addIter(Node node, int index, int value){
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
            node.next = new Node(value, node.next);
        }

    }

    //Рекурсивное добавление элемента на i-ую позицию
    public static void addRec(Node node, int index, int value){
        if (index == 0) {
            System.out.println("addRec(node, index, value): вставка в 0 позицию невозможна");
        }else if(index > sizeRec(node)){
            System.out.println("addRec(node, index, value): вставка невозможна, т.к. индекс больше длины списка");
        }else if(index == 1){
            node.next = new Node(value, node.next);
        } else addRec(node.next, index - 1, value);

    }

    //Итеративное удаление элемента из конца списка (из головы)
    public static void removeIter(Node node){
        if (node.next == null || node == null) return;
        while (node.next.next != null){
            node = node.next;
        }
        node.next = null;
    }

    //Рекурсивное удаление элемента из конца списка (из головы)
    public static void removeRec(Node node){
        if (node.next == null || node == null) return;
        if (node.next.next == null) {
            node.next = null;
        }else {
            removeRec(node.next);
        }
    }

    //Итеративное удаление элемента из i-ой позиции
    public static void removeIter(Node node, int index){
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
            node.next = node.next.next;
        }

    }

    //Рекурсивное удаление элемента из i-ой позиции
    public static void removeRec(Node node, int index){
        if (index == 0) {
            System.out.println("removeRec(node, index): удаление из 0 позиции невозможно");
        }else if(index >= sizeRec(node)){
            System.out.println("removeRec(node, index): удаление невозможно, т.к. индекс больше длины списка");
        }else if(index == 1){
            node.next = node.next.next;
        } else removeRec(node.next, index - 1);

    }
}
