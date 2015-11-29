package com.Novosib;

import java.io.IOException;

/**
 * Created by AdminAccount on 29.11.2015.
 *
 * На месте комментария можно:
 * - оставить комментарий;
 * - вставить throw new NullPointerException();
 * - вставить throw new RuntimeException();
 * - вставить throw new IOException();
 * - вставить throw new Error();
 * - привести примеры всех возможных трасс, которые может вывести этот код
 *
 * Получилось 16 вариантов
 */
public class ExMechMultiCatch {
    public static void main(String[] args) throws IOException {
        System.out.println("0");
        try{
            System.out.println("1");
            if (true){/*...*/}
            System.out.println("2");
        } catch (NullPointerException ex){
            System.out.println("3");
            if (true){/*...*/}
            System.out.println("4");
        } catch (RuntimeException ex) {
            System.out.println("5");
            if (true) {/*...*/}
            System.out.println("6");
        } catch (Exception ex) {
            System.out.println("7");
            if (true) {/*...*/}
            System.out.println("8");
        } finally {
            System.out.println("9");
            if (true){/*...*/}
            System.out.println("10");
        }
        System.out.println(11);
    }

}