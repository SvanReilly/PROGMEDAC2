package serviciosProcesos2Tema5;

public class CountingThread extends Thread {

    
    private int id; // Identificador del  hilo
    private int limite; // Limite de la secuencia
    private Counter counter; // Objeto Counter utilizado por el hilo

    // Constructor de la clase CountingThread que recibe un identificador, un numero y un objeto Counter
    public CountingThread(int id, int limite, Counter counter) {
        this.id = id;
        this.limite = limite;
        this.counter = counter;
    }

    // Run, se ejecuta cuando el hilo comienza a correr
    @Override
    public void run() {
        // Verifica si el contador se encuentra sincronizado
        if (counter.sincronizado) {
            // Imprime numeros sincronizadamente
            counter.imprimirNumerosSincronizados(limite, id);
        } else {
            // Imprime numeros de forma no sincronizada
            counter.imprimirNumeros(limite, id);
        }
    }
}
