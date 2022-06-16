package org.ramonfpy.hilos.runnable;

public class ViajeTarea implements Runnable{

    private String nombre;

    public ViajeTarea() {
    }

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " -> " + nombre);
            try {
                Thread.sleep((long)(Math.random()) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Me voy de viaje a: " + nombre);
    }
}
