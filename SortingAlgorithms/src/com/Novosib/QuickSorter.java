package com.Novosib;

/**
 * Created by AdminAccount on 21.11.2015.\
 * Быстрая сортировка быстрее сотировки слиянием
 * На 1.000.000 они примерно одинаковы (70 - 100 мс), а на 100.000.000 разница уже ощущается : 4100 мс. против 6500 мс.
 *
 */
public class QuickSorter extends Sorter{

    public void sortArray(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    public void quickSort(int[] arr, int from, int len){
        if (len < 2) return;
        int etalonIndex = from + len / 2;
        int etalonNumber = arr[etalonIndex];

        int l = from, r = from + len -1;
        while (l < r){
            if(arr[l] < etalonNumber) l++;
            else {
                while (arr[r] > etalonNumber && l < r){
                    r--;
                }
                if (l < r){
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    l++; r--;
                }
            }
        }
        etalonIndex = from;
        while (arr[etalonIndex] < etalonNumber){
            etalonIndex++;
        }

        //Теперь у нас слева от эталонного элемента все числа, меньшие него. А справа - те что больше него
        //Вызовем метод для "переброшенных" частей
        quickSort(arr, from, etalonIndex - from);
        quickSort(arr, etalonIndex + 1, (from + len) - etalonIndex - 1);

    }
}