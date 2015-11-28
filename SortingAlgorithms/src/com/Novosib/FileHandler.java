package com.Novosib;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by AlexanderFjodorov on 10.11.2015.
 * Класс предоставляет два метода: чтение целочисленного набора из файла в массив и наоборот, запись чисел из массива в файл
 */

public class FileHandler {

    public static int[] fileToArr(File file){
        //Метод читает данные из файла и возвращает их в виде целочисленного массива

        ArrayList<String[]> listStringArrays = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            //Читаем данные из файла построчно, переводя каждую строку в текстовый массив и сохраняя этот массив в ArrayList
            String line;
            while ((line = reader.readLine()) != null){
                listStringArrays.add( line.split(" ") );
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Возьмем элементы всех массивов, находящихся в listStringArrays, преобразуем их в числа и сложим в единый ArrayList
        ArrayList<Integer> listInt = new ArrayList<>();
        for (String[] arrString : listStringArrays){
            for (String str : arrString){
                listInt.add(Integer.parseInt(str));
            }
        }
        //Переведем ArrayList в числовой массив и вернем массив
        int[] arrInt = new int[listInt.size()];
        for (int i = 0; i < arrInt.length; i++){
            arrInt[i] = listInt.get(i);
        }
        return arrInt;
    }

    public static void arrToFile(int[] arr, File resultFile){
        //Метод читает данные из массива, и записывает их в файл "resultFile"

        try {
            FileWriter writer = new FileWriter(resultFile);
            for (int element : arr){
                writer.write(element + " ");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
