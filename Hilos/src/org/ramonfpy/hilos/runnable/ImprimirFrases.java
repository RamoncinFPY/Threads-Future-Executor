package org.ramonfpy.hilos.runnable;

//En vez de importar el método static de abajo.
//import org.ramonfpy.hilos.EjemploSincronizedThread;

import static org.ramonfpy.hilos.EjemploSincronizedThread.imprimirFrases;

public class ImprimirFrases implements Runnable {
    String frase1, frase2;

    public ImprimirFrases() {
    }

    public ImprimirFrases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        //EjemploSincronizedThread.imprimirFrases (this.frase1, this.frase2);
        imprimirFrases (this.frase1, this.frase2);
    }
}
