package org.ramonfpy.hilostimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodoAtomicInteger {

    public static void main(String[] args) {

        Timer timer = new Timer();

        //TimerTask() es abstracta e implementa el Runnable.
        timer.schedule(new TimerTask() {
            //Para agregar un sonido cuando inicie cada tarea.
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            AtomicInteger atomicInteger = new AtomicInteger(3);
            private int tareasRealizadas = 1;
            @Override
            public void run() {
                int contador = atomicInteger.getAndDecrement();
                if (contador > 0) {
                    toolkit.beep();
                    System.out.println("\t-> "  + tareasRealizadas + ".- Tarea periódica: " + new Date() + "\tNombre del Thread: " +
                            Thread.currentThread().getName());
                    tareasRealizadas++;
                } else {
                    System.out.println("\t\tTareas realizadas: " + (tareasRealizadas - 1));
                    timer.cancel();
                }
            }
        }, 5000, 10000);

        System.out.println("La tarea iniciará después de 5 segundos y se realizará cada 10 segundos.");
    }
}
