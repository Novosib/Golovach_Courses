package com.Novosib.GolovachCources.JavaCore2012.Thread.Lab1;

/**
 * Created by AdminAccount on 03.12.2015.
 Модифицируйте/допишите код сохранив функциональность, но увеличив количество потоков.
 Сейчас есть 3 потока:
 1) поток метода main(...)
 2) поток threadA
 3) поток threadB
 Требуется добавить потоки threadC и threadCoordinator.
 4) в threadC из потока метода main() вынести печать буквы 'C'
 5) в threadCoordinator вынести из метода main(...) функционал создания, старта
 и ожидания завершения потоков threadA+threadB+threadC.
 Общий сценарий должен быть следующим:
 - поток метода main(...) создает, стартует и ожидает завершения потока threadCoordinator
 - поток threadCoordinator циклически создает, запускает потоки threadA и threadB
 (они работают одновременно), дожидается их окончания, по окончанию создает, стартует
 и ожидает завершения потока threadC.
 */

public class Play_the_accordion {
    public static void main(String[] args) throws InterruptedException {
        for (int k = 0; k < 10; k++) {
            // A + B
            Runnable printerA = new PrintRunnable("A   .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();
            Runnable printerB = new PrintRunnable(".   B", 99);
            Thread threadB = new Thread(printerB);
            threadB.start();
            threadA.join();
            threadB.join();
            // C
            System.out.println("-----");
            Runnable printerC = new PrintRunnable("  C", 100);
            printerC.run();
            System.out.println("-----");
        }
    }
}
