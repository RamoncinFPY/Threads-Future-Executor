package org.ramonfpy.hilostimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimerPeriodo {

    public static void main(String[] args) {

        Timer timer = new Timer();

        //TimerTask() es abstracta e implementa el Runnable.
        timer.schedule(new TimerTask() {
            private int contador = 3;
            private int tareasRealizadas = 1;
            @Override
            public void run() {
                if (contador > 0) {
                    System.out.println("\t-> "  + tareasRealizadas + ".- Tarea periódica: " + new Date() + "\tNombre del Thread: " +
                            Thread.currentThread().getName());
                    tareasRealizadas++;
                    contador--;
                } else {
                    System.out.println("\t\tTareas realizadas: " + (tareasRealizadas - 1));
                    timer.cancel();
                }
            }
        }, 5000, 10000);

        System.out.println("La tarea iniciará después de 5 segundos.");
    }
}
