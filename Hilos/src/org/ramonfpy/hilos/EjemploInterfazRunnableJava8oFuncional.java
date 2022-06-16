package org.ramonfpy.hilos;

import org.ramonfpy.hilos.runnable.ViajeTarea;


public class EjemploInterfazRunnableJava8oFuncional {

    public static void main(String[] args) throws InterruptedException {
/*
        Runnable viaje = new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " -> " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long)(Math.random()) * 1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Me voy de viaje a: " + Thread.currentThread().getName());
            }
        };
*/

        System.out.println("Runable con lambda");

        Thread main = Thread.currentThread();

        Runnable viaje = () -> {

            String nombre = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " -> " + nombre);
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Me voy de viaje a: " + nombre);
            System.out.println("estado del main -> " + main.getState());
        };

        Thread v1 = new Thread (viaje,"Costa - Ecuador");
        Thread v2 = new Thread (viaje, "Sierra - Ecuador");
        Thread v3 = new Thread (viaje, "Oriente - Ecuador");
        Thread v4 = new Thread (viaje, "Islas Galápagos - Ecuador");

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        v1.join();
        v2.join();
        v3.join();
        v4.join();

        //Thread.sleep(10000); //Hay que calcular el tiempo de retraso para que se imprima la siguiente línea.

        System.out.println("Usando Thead v1; v1.start(); v1.join();");

        System.out.println("Continuando con la ejecución del método main: " + main.getName());
    }
}
