package com.Novosib.GolovachCources.JavaCore2012.SortingAlgorithms;

/**
 * Created by AlexanderFjodorov on 12.11.2015.
 */
public class Stack {

    //Стек имеет три составляющих: размер стека, массив элементов стека и номер последнего (головного) элемента
    private String[] content;
    private int size;
    private int head = -1;

    public Stack(int n){
        size = n;
        content = new String[n];
    }

    //Метод добавления элемента в стек
    public void push(String s){
        if (head < (size - 1)){
            head++;
            content[head] = s;
            System.out.println("Элемент добавлен на позицию № " + head);
        } else {
            System.out.println("Стек полностью заполнен. Добавление невозможно");
        }
    }

    //Метод удаления последнего элемента из стека
    public String pop(){
        if (head >= 0){
            System.out.println("Элемент удален из позиции № " + head);
            String s = content[head];
            content[head] = null;
            head--;
            return s;
        } else {
            System.out.println("Стек пуст. Забирать из него больше нечего...");
            return null;
        }
    }

    //Метод, печатающий содержимое стека
    public void printStack(){
        System.out.print("Содержимое стека: ");
        for (int i = 0; i < size; i++){
            System.out.print(content[i] + " ");
        }
    }

    //Тестирование: создаем стек, наполняем его, очищаем его
    public static void main(String[] args) {

        Stack stack = new Stack(5);
        for (int i = 0; i < 6; i++){
            stack.printStack();
            System.out.println();
            System.out.print("i = " + i + ": ");
            stack.push("A" + i);
        }
        System.out.println();
        for (int i = 0; i < 6; i++){
            stack.printStack();
            System.out.println();
            System.out.print("i = " + i + ": ");
            stack.pop();
        }
    }

}