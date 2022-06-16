package org.ramonfpy.hilossynchronized.runnable;

import org.ramonfpy.hilossynchronized.modelo.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable {

    private Panaderia panaderia;

    public Panadero() {
    }

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            panaderia.hornear("pan Nº: " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
