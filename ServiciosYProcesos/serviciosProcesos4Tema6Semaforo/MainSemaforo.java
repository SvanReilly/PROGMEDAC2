package serviciosProcesos4Tema6Semaforo;

public class MainSemaforo {
    public static void main(String[] args) {

        BufferSemaforo bufferSemaforo = new BufferSemaforo();

        final int consum = 2000;
        final int produc = 1000;

        Consumidor consumidor = new Consumidor(bufferSemaforo, consum);
        Productor productor = new Productor(bufferSemaforo, produc);

        productor.start();
        consumidor.start();
    }
}