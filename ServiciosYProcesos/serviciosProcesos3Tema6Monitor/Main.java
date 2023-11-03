package serviciosProcesos3Tema6Monitor;

public class Main {
    public static void main(String[] args) {
        
        final int consum = 2000;
        final int produc = 1000;

        Buffer buffer = new Buffer();

        Productor productor = new Productor(buffer, produc);
        Consumidor consumidor = new Consumidor(buffer, consum);

        productor.start();
        consumidor.start();

    }
}