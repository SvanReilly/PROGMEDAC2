package serviciosProcesos3Tema6Monitor;

public class Consumidor extends Thread {
    private Buffer buffer;
    private int dormir;

    public Consumidor(Buffer buffer, int dormir) {
        this.buffer = buffer;
        this.dormir = dormir;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int valor = buffer.get(); 
            try {
                System.out.println("Consumidor saca: " + valor);
                sleep(dormir); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
