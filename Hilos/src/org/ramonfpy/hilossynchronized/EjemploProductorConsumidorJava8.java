package org.ramonfpy.hilossynchronized;

import org.ramonfpy.hilossynchronized.modelo.Panaderia;
import org.ramonfpy.hilossynchronized.runnable.Consumidor;
import org.ramonfpy.hilossynchronized.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {

        Panaderia p = new Panaderia();

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                p.hornear("pan Nº: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                p.consumir();
            }
        }).start();

    }
}
