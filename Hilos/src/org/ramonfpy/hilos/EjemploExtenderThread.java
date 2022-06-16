package org.ramonfpy.hilos;

import org.ramonfpy.hilos.threads.NombreThread;

public class EjemploExtenderThread {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Threads, lo maneja la cpu y la máquina virtual de java.");

        Thread hilo = new NombreThread("Ramón");
        hilo.start();
        //Thread.sleep(1000); //Pausa principal del método main no del NombreThread.

        Thread hilo1 = new NombreThread("Francisco");
        hilo1.start();

        NombreThread hilo2 = new NombreThread("Portalanza");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("Yerovi");
        hilo3.start();

        System.out.println(hilo.getState());
    }
}
