package com.Novosib.GolovachCources.JavaCore2012.SortingAlgorithms;

import java.io.File;
import java.util.Calendar;

/**
 * Created by AlexanderFjodorov on 11.11.2015.
 * Данный интерфейс объявляет методы сортировки данных:
 * - Метод sortArray сортирует данные в массиве,
 * - Метод sortFile сортирует данные, находящиеся в файле
 */
public abstract class Sorter {

    public abstract void sortArray(int[] arr);

    public void sortFile(File file, File resultFile){
        //Метод читает данные из файла "file", сортирует их с помощью алгоритма "Сортировка пузырьком"
        //и записывает результат в файл "resultFile"

        int[] arrInt = FileHandler.fileToArr(file);

        long startTime = Calendar.getInstance().getTimeInMillis();
        this.sortArray(arrInt);
        long finishTime = Calendar.getInstance().getTimeInMillis();
        long sortTime = finishTime - startTime;
        System.out.println("Время сортировки (Millis): " + sortTime);

        FileHandler.arrToFile(arrInt, resultFile);


    }

}
