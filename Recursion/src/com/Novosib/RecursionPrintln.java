package com.Novosib;

/**
 * Created by AdminAccount on 21.11.2015.
 */
public class RecursionPrintln {

    public static void main(String[] args) {
        f(1);
    }

    public static void f(int x){
        System.out.print(x + " -> " );
        if(x < 15) f(2 * x);
        System.out.print(" <- " + x);
    }

}