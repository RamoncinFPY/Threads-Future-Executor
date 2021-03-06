package org.ramonfpy.hilossynchronized.modelo;

public class Panaderia {

    private String pan;
    private boolean disponible;

    public synchronized void hornear (String masa) {

        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.pan = masa;
        System.out.println("-> El panadero hornea el " + this.pan);
        this.disponible = true;
        notify();
    }

    public synchronized String consumir () {

        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("\tCliente comprando el " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }
}
