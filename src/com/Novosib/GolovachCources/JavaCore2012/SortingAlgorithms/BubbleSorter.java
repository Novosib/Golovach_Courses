package com.Novosib.GolovachCources.JavaCore2012.SortingAlgorithms;

/**
 * Created by AlexanderFjodorov on 08.11.2015.
 * Этот класс-сортировщик реализует методы сортировки данных "Пузырьком":
 * - Метод sortArray сортирует данные в массиве,
 * - Метод sortFile сортирует данные, находящиеся в файле
 *
 * Алгоритм имеет сложность O(n*n). Он малоэффективен, но очень прост и понятен. А так же его можео улучшать.
 *
 * Улучшение №1.
 * Рассмотрим ситуацию, когда на каком-либо из проходов не произошло ни одного обмена.
 * Это значит, что все пары расположены в правильном порядке, массив уже отсортирован и продолжать процесс не имеет смысла.
 * Итак, первое улучшение заключается в запоминании, производился ли на данном проходе какой-либо обмен.
 * Если нет - алгоритм заканчивает работу.
 *
 * Улучшение №2.
 * Массив [1 2 3 4 0] будет отсортирован проходами направо (сдвигая наибольший элемент) за 4 шага.
 * Однако, если бы его сортировали проходами налево (сдвигая наименьший элемент), то потребовался бы всего 1 проход
 * Для эффективной обработки таких ситуаций можно чередовать проходы направо и налево
 * Этот метод называется шейкер-сортировкой
 *
 */
public class BubbleSorter extends Sorter{

    boolean shake = true;//Вариант сортировки шейкер - пузырьком
    boolean printStep = false;//Печатать массив после каждой итерации

    int changeNum = 0;//Счетчик (информационно), сколько обменов сделано
    int cycleNum = 0;//Счетчик (информационно), сколько проходов по массиву сделано
    boolean stop;//Если на последнем шаге замен не было, то процесс можно не продолжать, т.к. массив уже отсортирован

    private void swap(int[] arr, int i, int j){//Обмен двух элементов массива
        int var = arr[i];
        arr[i] = arr[j];
        arr[j] = var;
        changeNum++;
    }

    public void printArray(int[] arr){
        System.out.print("[ ");
        for (int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }

    public void sortArray(int[] arr){

        if(shake){
            shakeSortArray(arr);//Если выбран режим шейкер-сортировки, то запускаем этот алгоритм, инече сортируем обычным пузырьком
        }else {
            for (int barier = arr.length - 1; barier >= 1; barier--) {
                stop = true;//На каждом круге предполагаем, что он будет последним и что после него массив будет отсортирован
                cycleNum++;
                for (int i = 0; i < barier; i++) {
                    if (arr[i] > arr[i + 1]) {
                        swap(arr, i, i + 1);
                        stop = false;//Если хоть одна замена произошла, то нужено будет сделать еще минимум один круг
                    }
                }
                if (stop) break;//Если продолжать не нужно - выходим из цикла
                if (printStep) printArray(arr);
            }
            System.out.println("Сортировка пузырьком. Потребовалось: " + changeNum + " обменов, и " + cycleNum + " проходов");
        }
    }

    public void shakeSortArray(int[] arr){

        int barierLeft = 0;
        int barierRight = arr.length - 1;

        while (barierLeft < barierRight){
            stop = true;//На каждом круге предполагаем, что он будет последним и что после него массив будет отсортирован

            //Пробегаем вправо
            for (int i = barierLeft; i < barierRight; i++){
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i + 1);
                    stop = false;//Если хоть одна замена произошла, то нужено будет сделать еще минимум один круг
                }
            }
            if (printStep) printArray(arr);
            cycleNum++;
            barierRight--;

            if (stop) break;//Если продолжать не нужно - выходим из цикла
            if (barierLeft == barierRight) break;//Барьеры совпали, значит весь массив остортирован, выходм из цикла

            //Пробегаем влево
            for (int i = barierRight; i > barierLeft; i--){
                if (arr[i] < arr[i-1]) {
                    swap(arr, i, i - 1);
                    stop = false;//Если хоть одна замена произошла, то нужено будет сделать еще минимум один круг
                }
            }
            if (printStep) printArray(arr);
            cycleNum++;
            barierLeft++;
        }

        System.out.println("Шейкер-Сортировка пузырьком. Потребовалось: " + changeNum + " обменов, и " + cycleNum + " проходов");
    }

}
