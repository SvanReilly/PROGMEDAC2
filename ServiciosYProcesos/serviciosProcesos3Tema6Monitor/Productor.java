package serviciosProcesos3Tema6Monitor;

public class Productor extends Thread{

    private Buffer buffer;
    private int dormir;

    public Productor(Buffer buffer, int dormir) {
        this.buffer = buffer;
        this.dormir = dormir;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.put(i); 
            try {   
                System.out.println("Productor pone: " + i);
                sleep(dormir); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
