package com.Novosib.GolovachCources.JavaCore2012.Thread.Lab2;

import com.Novosib.GolovachCources.JavaCore2012.Thread.Lab1.PrintRunnable;

/**
 * Created by AdminAccount on 03.12.2015.
 * Модифицируйте/допишите код. Сейчас поток, в котором работает метод main(), циклически вбрасывает потоки-"сигнальные ракеты",
 * которые пишут по 10 раз в консоль и умирают. На лицо асимметрия: main() породлает, printer() печатает.
 * Сделайте новый класс RabbitPrinter, который и пишет в консоль, и порождает каждую секунду новые RabbitPtinter-ы
 */
public class Rabbit_Attack {
    public static void main(String[] args) throws InterruptedException {
        for (int k = 1; k < 10; k++){
            String spaces = spaces(k);
            Runnable printer = new PrintRunnable(spaces + k, 100);
            Thread thread = new Thread(printer);
            thread.start();
            Thread.sleep(100);
        }
    }

    private static String spaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++){
            result += " ";
        }
        return result;
    }
}
