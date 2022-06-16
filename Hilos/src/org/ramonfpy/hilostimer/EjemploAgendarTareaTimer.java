package org.ramonfpy.hilostimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {

    public static void main(String[] args) {

        Timer timer = new Timer();

        //TimerTask() es abstracta e implementa el Runnable.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\t-> Tarea realizada el: " + new Date() + "\tNombre del Thread: " +
                        Thread.currentThread().getName());
                System.out.println("\t\tFinaliza el tiempo...");

                timer.cancel();
            }
        }, 5000);
        System.out.println("La tarea iniciará después de 5 segundos.");
    }
}
