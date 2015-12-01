package com.Novosib.GolovachCources.JavaCore2012.DynamicDataStructure;

/**
 * Created by AdminAccount on 25.11.2015.
 */
public class TreeFibonacci {
    private static int depth = 0;

    public static void main(String[] args) {
        TNode fibonacci = generateTreeFibonacci(3);
        printTree(fibonacci);

    }

    public static TNode generateTreeFibonacci(int index){//Рекурсивная генерация дерева с "корня"
        TNode node;
        if(index < 2) {
            node = new TNode(index, null, null);
        }else{
            TNode nextLeft = generateTreeFibonacci(index - 1);
            TNode nextRight = generateTreeFibonacci(index - 2);
            node = new TNode(nextLeft.value + nextRight.value, nextLeft, nextRight);
        }
        return node;
    }

    //Следующие методы используются для визуального представления делева
    public static void printTree(TNode node){
        in(node.value);
        if(node.nextLeft != null) printTree(node.nextLeft);
        if(node.nextRight != null) printTree(node.nextRight);
        out(node.value);
    }
    public static void in(int x){
        spaces();
        System.out.println("(" + x + ")->");
        depth++;
    }
    public static void out(int x){
        depth--;
    }
    private static void spaces(){
        for(int k = 0; k < depth; k++) {
            System.out.print("    ");
        }
    }
}
