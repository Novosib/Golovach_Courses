package com.Novosib.GolovachCources.JavaCore2012.SortingAlgorithms;

/**
 * Created by AdminAccount on 21.11.2015.
 */
public class MergeSorter extends Sorter {
    @Override
    public void sortArray(int[] arr) {
        int[] arrSort = mergeSort(arr, 0, arr.length);
        for (int i = 0; i < arr.length; i ++){
            arr[i] = arrSort[i];
        }
    }

    public int[] mergeSort(int[] arr, int from, int len){
        if (len == 0) return new int[0];
        else if (len == 1) return new int[]{arr[from]};
        else if (len == 2){
            if(arr[from] < arr[from + 1]){
                return new int[]{arr[from],arr[from + 1]};
            } else {
                return new int[]{arr[from + 1],arr[from]};
            }
        } else {
            int[] left = mergeSort(arr, from, len / 2);
            int[] right = mergeSort(arr, from + (len / 2), len - (len / 2));
            return merge(left, right);
        }
    }



    public int[] merge(int[] a, int[] b){
        //Метод слияния двух отсортированных массивов.
        //Сначала создаем пустой итоговый массив и заводим два "бегунка" по отсортированным массивам:
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0;

        //Делаем поэлементное сравление массивов и заполняем итговый массив наименьшими элементами
        //Процесс идет до тех пор, пока не дойдем до конца одного из массивов:
        while (i < a.length && j < b.length){
            if(a[i] <= b[j]){
                c[i + j] = a[i]; i++;
            }else {
                c[i + j] = b[j]; j++;
            }
        }

        //Если в каком-то массиве бегунок не дошел до края, значит это самые большие элементы
        //и мы просто переносим их втом же порядке в итоговый массив:
        while (i < a.length) {
            c[i + j] = a[i]; i++;
        }
        while (j < b.length) {
            c[i + j] = b[j]; j++;
        }
        return c;
    }

}