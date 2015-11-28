package com.Novosib;

import java.io.*;
import java.util.Calendar;

/**
 * Created by AlexanderFjodorov on 08.11.2015.
 */
public class SortingTester {

    private int[] array;
    private File file;
    private File fileSort;

    public void setReverseArray(int len) {
        this.array = new int[len];
        for (int i = 0; i <= len - 1; i++){
            this.array[i] = len - i;
        }
    }

    public void setRandomArray(int len) {
        this.array = new int[len];
        for (int i = 0; i <= len - 1; i++){
            this.array[i] = (int) (Math.random() * len);
        }
    }

    public void setReverseFile(String fileName, int len) {
        this.file = new File(fileName);
        this.fileSort = new File(fileName.replace(".txt","Sort.txt"));//Заменяем  ".txt" в названии файла на "Sort.txt"
        try {
            FileWriter writer = new FileWriter(this.file);
            for (int i = 0; i <= len - 1; i++){
                writer.write((len - i) + " ");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException в методе setReverseFile");
        }
    }

    public void setRandomFile(String fileName, int len) {
        this.file = new File(fileName);
        this.fileSort = new File(fileName.replace(".txt","Sort.txt"));//Заменяем  ".txt" в названии файла на "Sort.txt"
        try {
            FileWriter writer = new FileWriter(this.file);
            for (int i = 0; i <= len - 1; i++){
                writer.write( ((int) (Math.random() * len)) + " ");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException в методе setReverseFile");
        }
    }

    public void printArray(int[] arr){
        System.out.print("[ ");
        for (int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }

    public void printFile(File file){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException в методе printFile");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException в методе printFile");
        }
    }

    public void arrayTest(int len, Sorter sorter){

        System.out.println("Сортировщик: " + sorter.getClass());
        this.setRandomArray(len);
        //System.out.println("Массив до сортировки:");
        //this.printArray(this.array);

        long startTime = Calendar.getInstance().getTimeInMillis();

        sorter.sortArray(this.array);

        long finishTime = Calendar.getInstance().getTimeInMillis();
        long sortTime = finishTime - startTime;
        System.out.println();
        System.out.println("Время сортировки (Millis): " + sortTime);

        //System.out.println("Массив после сортировки:");
        //this.printArray(this.array);
    }

    public void fileTest(String fileName, int len, Sorter sorter){

        System.out.println("Сортировщик: " + sorter.getClass());
        this.setReverseFile(fileName, len);
        //System.out.println("Файл до сортировки:");
        //this.printFile(this.file);

        sorter.sortFile(this.file, this.fileSort);
        //System.out.println("Файл после сортировки:");
        //this.printFile(this.fileSort);

    }
}


