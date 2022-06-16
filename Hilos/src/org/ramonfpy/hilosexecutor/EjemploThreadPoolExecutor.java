package org.ramonfpy.hilosexecutor;

import java.util.concurrent.*;

public class EjemploThreadPoolExecutor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        //ExecutorService executor = Executors.newSingleThreadExecutor();
        //Para obtener más opciones para el executor.
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        // executor.set //Tiene varias configuraciones.
        System.out.println("El tamaño del pool: " + executor.getPoolSize());
        System.out.println("El tamaño de la cola: " + executor.getQueue().size());

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

        Callable<Integer> tarea2 = () -> {
            System.out.println("Esta es la tarea 2...");
            TimeUnit.SECONDS.sleep(3);
            return 7;
        };

        //Con submit(Callable<T>, task); devuelve la tarea.
        Future<String> resultado = executor.submit(tarea);
        Future<String> resultado1 = executor.submit(tarea);
        Future<Integer> resultado2 = executor.submit(tarea2);

        System.out.println("El tamaño del pool: " + executor.getPoolSize());
        System.out.println("El tamaño de la cola: " + executor.getQueue().size());

        executor.shutdown(); //shutdownNow() finaliza abruptamente aún las taras que no se han realizado.

        System.out.println("Continuando la ejecución del método main 1");
        //System.out.println("Ha finalizado la tarea? -> " + resultado.isDone()); //Si la tarea ha terminado.
        //Podemos realizar el isDone con un while.
        while ( !(resultado.isDone() && resultado1.isDone() && resultado2.isDone()) ) {
            System.out.println(String.format("Tarea 0: %s, Tarea 1: %s, Tarea 2: %s",
                    resultado.isDone() ? "Finalizó." : "En proceso",
                    resultado1.isDone() ? "Finalizó." : "En proceso",
                    resultado2.isDone() ? "Finalizó." : "En proceso"));

            TimeUnit.MICROSECONDS.sleep(1000);
        }

        System.out.println("El get devuelve tarea 0 -> " + resultado.get());
        System.out.println("Ha finalizado la tarea 0? -> " + resultado.isDone()); //Si la tarea ha terminado.
        System.out.println("El get devuelve tarea 1 -> " + resultado1.get());
        System.out.println("Ha finalizado la tarea 1? -> " + resultado.isDone()); //Si la tarea ha terminado.
        System.out.println("El get devuelve tarea 2 -> " + resultado2.get());
        System.out.println("Ha finalizado la tarea 2? -> " + resultado.isDone()); //Si la tarea ha terminado.
    }
}
