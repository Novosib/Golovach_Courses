package com.Novosib.GolovachCources.JavaCore2012.Recursion;

/**
 * Created by AdminAccount on 21.11.2015.
 */
public class FibonacciQuiz {

    public static void main(String[] args) {
        f(4);
    }

    public static int f(int x){
        System.out.print(" " + x);
        return (x < 2)? x : f(x - 2) + f(x - 1);
    }
}