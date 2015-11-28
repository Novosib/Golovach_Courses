package com.Novosib;

/**
 * Created by AdminAccount on 24.11.2015.
 */
public class TreeNodeUtils {
    private static int depth = 0;

    public static void main(String[] args) {
        TNode root = generateTree(4);
        root.nextLeft.nextLeft.nextLeft.nextLeft = new TNode(20, null, null);
        System.out.println("Размер дерева = " + size(root));
        System.out.println("Высота дерева = " + height(root));
        System.out.println("Макс.эл. дерева = " + max(root));
        printTree(root);
    }

    public static TNode generateTree(int value){//Рекурсивная генерация дерева с "корня"n
        TNode node = new TNode(value, null, null);
        if(value > 1){
            node.nextLeft = generateTree(value - 1);
            node.nextRight = generateTree(value - 2);
        }
        return node;
    }

    //Размер дерева
    public static int size(TNode node){
        if (node == null) return 0;
        else return 1 + size(node.nextLeft) + size(node.nextRight);
    }

    //Высота дерева
    public static int height(TNode node){
        if (node == null) return 0;
        else {
            return 1 + Math.max(height(node.nextLeft), height(node.nextRight));
        }
    }

    //Максимальный элемент в дереве
    public static int max(TNode node){
        if (node == null) return 0;
        else {
            return Math.max(node.value, Math.max(max(node.nextLeft), max(node.nextRight)));
        }
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
