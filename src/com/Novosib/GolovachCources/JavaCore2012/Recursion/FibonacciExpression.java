package com.Novosib.GolovachCources.JavaCore2012.Recursion;

/**
 * Created by AdminAccount on 21.11.2015.
 */
public class FibonacciExpression {

    public static void main(String[] args) {
        f(3);
    }

    public static int f(int x){
        if(x < 2){
            return abc(x);
        } else {
            return a(x) + f(x - 2) + b(x) + f(x - 1) + c(x);
        }
    }

    public static int abc(int x){
        System.out.print(x); return  x;
    }

    public static int a(int x){
        System.out.print("("); return  0;
    }

    public static int b(int x){
        System.out.print("+"); return  0;
    }

    public static int c(int x){
        System.out.print(")"); return  0;
    }
}
