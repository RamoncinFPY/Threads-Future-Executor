package org.ramonfpy.hilos;

import org.ramonfpy.hilos.runnable.ViajeTarea;

public class EjemploInterfazRunnable {

    public static void main(String[] args) {

        new Thread (new ViajeTarea("Costa - Ecuador")).start();
        new Thread (new ViajeTarea("Sierra - Ecuador")).start();
        new Thread (new ViajeTarea("Oriente - Ecuador")).start();
        new Thread (new ViajeTarea("Islas Galápagos - Ecuador")).start();

    }
}
