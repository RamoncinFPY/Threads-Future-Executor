package org.ramonfpy.hilossynchronized.runnable;

import org.ramonfpy.hilossynchronized.modelo.Panaderia;

public class Consumidor implements Runnable {

    private Panaderia panaderia;

    public Consumidor() {
    }

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            panaderia.consumir();
        }
    }
}
