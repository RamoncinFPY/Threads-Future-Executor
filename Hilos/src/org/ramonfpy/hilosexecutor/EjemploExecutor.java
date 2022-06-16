package org.ramonfpy.hilosexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = ()-> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
                //TimeUnit.SECONDS.sleep(1);
                TimeUnit.SECONDS.sleep(5); //Se muestran los 2 sout de main.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea...");
        };
        //Con submit(Callable<T>, task); devuelve la tarea.
        executor.submit(tarea);
        executor.shutdown(); //shutdownNow() finaliza abruptamente aún las taras que no se han realizado.
        System.out.println("Continuando la ejecución del método main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Continuando la ejecución del método main 2");
    }
}
