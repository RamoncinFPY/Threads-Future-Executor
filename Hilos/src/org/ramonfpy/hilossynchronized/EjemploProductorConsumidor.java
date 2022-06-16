package org.ramonfpy.hilossynchronized;

import org.ramonfpy.hilossynchronized.modelo.Panaderia;
import org.ramonfpy.hilossynchronized.runnable.Consumidor;
import org.ramonfpy.hilossynchronized.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {

        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();

    }
}
