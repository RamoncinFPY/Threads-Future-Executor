package org.ramonfpy.hilosexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFutureCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = ()-> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
                //TimeUnit.SECONDS.sleep(1);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea...");
            return "Aquí se imprime algún resultado de la tarea.";
        };
        //Con submit(Callable<T>, task); devuelve la tarea.
        Future<String> resultado = executor.submit(tarea);
        executor.shutdown(); //shutdownNow() finaliza abruptamente aún las taras que no se han realizado.

        System.out.println("Continuando la ejecución del método main 1");
        //System.out.println("Ha finalizado la tarea? -> " + resultado.isDone()); //Si la tarea ha terminado.
        //Podemos realizar el isDone con un while.
        while (!resultado.isDone()) {
            System.out.println("Ejecutando la tarea...");
            TimeUnit.MICROSECONDS.sleep(1500);
        }

        System.out.println("El get devuelve -> " + resultado.get());
        System.out.println("Ha finalizado la tarea? -> " + resultado.isDone()); //Si la tarea ha terminado.
    }
}
