package com.Novosib.GolovachCources.JavaCore2012.Exceptions;

/**
 * Created by AdminAccount on 29.11.2015.
 *
 * На месте комментария можно:
 * - оставить екомментарий;
 * - вставить throw new NullPointerException();
 * - вставить throw new Error();
 * - привести примеры всех возможных трасс, которые может вывести этот код
 *
 * Получилось 8 вариантов
 */
public class ExMechSimple {

    public static void main(String[] args) {
        System.out.println("0");
        try{
            System.out.println("1");
            if (true){/*...*/}
            System.out.println("2");
        } catch (RuntimeException ex){
            System.out.println("3");
            if (true){/*...*/}
            System.out.println("4");
        } finally {
            System.out.println("5");
            if (true){/*...*/}
            System.out.println("6");
        }
        System.out.println("7");
    }
}
