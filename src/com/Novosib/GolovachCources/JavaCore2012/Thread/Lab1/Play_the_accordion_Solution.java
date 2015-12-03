package com.Novosib.GolovachCources.JavaCore2012.Thread.Lab1;

/**
 * Created by AdminAccount on 03.12.2015.
 */
public class Play_the_accordion_Solution {
    public static void main(String[] args) throws InterruptedException {
        // Coordinator
        Runnable coordinator = new CoordinatorRunnable();
        Thread threadCoor = new Thread(coordinator);
        threadCoor.start();
        threadCoor.join();
        System.out.println("!!! The end !!!");
    }
}
