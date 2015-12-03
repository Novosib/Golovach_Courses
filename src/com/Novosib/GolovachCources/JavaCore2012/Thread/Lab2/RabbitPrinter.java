package com.Novosib.GolovachCources.JavaCore2012.Thread.Lab2;

/**
 * Created by AdminAccount on 03.12.2015.
 */
public class RabbitPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println(RabbitLab.num++ + " rabbit!!!");
        new Thread(new RabbitPrinter()).start();
        new Thread(new RabbitPrinter()).start();

    }
}
