package org.ramonfpy.hilos;

import org.ramonfpy.hilos.runnable.ImprimirFrases;

public class EjemploSincronizedThread {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new ImprimirFrases("Bienvenido, ", "Ramón Francisco")).start();
        new Thread(new ImprimirFrases("¿Necesitas algo, ", "de mí?")).start();
        Thread.sleep(100);

        Thread h3 = new Thread(new ImprimirFrases("Estoy, ", "para servirte!"));
        h3.start();
        Thread.sleep(200);

        System.out.println(h3.getState());

    }

    public synchronized static void imprimirFrases (String frase1, String frase2) {
        System.out.print(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(frase2);
    }
}
