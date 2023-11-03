package serviciosProcesos4Tema6Semaforo;

import java.util.concurrent.Semaphore;

public class BufferSemaforo {
    private int contenido;
    private Semaphore semConsumidor = new Semaphore(0);
    private Semaphore semProductor = new Semaphore(1);
    
    public int get() {
        try {
            semConsumidor.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int valor = contenido;
        semProductor.release();
        return valor;
    }

    public void put(int valor) {
        try {
            semProductor.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contenido = valor;
        semConsumidor.release();
    }
}
