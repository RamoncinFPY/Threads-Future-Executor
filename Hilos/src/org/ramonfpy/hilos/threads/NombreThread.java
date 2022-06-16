package org.ramonfpy.hilos.threads;

public class NombreThread extends Thread{

    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        //super.run();
        System.out.println("Se inicia el método run del thread -> " + getName());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println(this.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Finaliza el thread.");
    }
}
