package com.Novosib;

/**
 * Created by AlexanderFjodorov on 08.11.2015.
 */
public class Main {
    public static void main(String[] args) {

        SortingTester sortingTester = new SortingTester();
        //sortingTester.arrayTest(10000, new BubbleSorter());//1 000 000 элементов - 800 530 Millis
        //sortingTester.fileTest("bubbleTest.txt", 10000, new BubbleSorter());

        sortingTester.arrayTest(10000000, new MergeSorter());//1 000 000 элементов - 100 Millis (ReverseArray) и 10 000 000 - элементов - 600 Millis (ReverseArray)
        //sortingTester.fileTest("mergeTest.txt", 10000, new MergeSorter());

        sortingTester.arrayTest(10000000, new QuickSorter());//1 000 000 элементов - 90 Millis (ReverseArray) и 10 000 000 - элементов - 450 Millis (ReverseArray)
    }
}