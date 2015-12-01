package com.Novosib.GolovachCources.JavaCore2012.SortingAlgorithms;

/**
 * Created by AdminAccount on 21.11.2015.
 *
 * В данном классе реализован метод слияния двух отсортированных массивов
 */
public class MergeArrays {

    public static void main(String[] args) {
        int[] a = {0,2,4,4,20,23};
        int[] b = {1,6,13};
        int[] c = MergeArrays.merge(a,b);
        System.out.print("[ ");
        for (int i = 0; i < c.length; i ++){
            System.out.print(c[i] + " ");
        }
        System.out.print("]");
    }


    public static int[] merge(int[] a, int[] b){
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
