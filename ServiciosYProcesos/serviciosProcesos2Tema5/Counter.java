package serviciosProcesos2Tema5;

public class Counter {

    // Variable que indica si el contador se encuentra sincronizado
    boolean sincronizado;

    // Constructor de la clase Counter que recibe un booleano para indicar si se encuentra sincronizado
    public Counter(boolean sincronizado) {
        this.sincronizado = sincronizado;
    }

    // Metodo que imprime números de forma sincronizada con un identificador de hilo y un limite
    public synchronized void imprimirNumerosSincronizados(int n, int id) {
        for (int i = 0; i <= n; i++) {
            System.out.println("Hilo " + id + " (sincronizado): " + i);
        }
    }

    // Metodo que imprime numeros de forma no sincronizada con un identificador de hilo y un limite
    public void imprimirNumeros(int n, int id) {
        for (int i = 0; i <= n; i++) {
            System.out.println("Hilo " + id + " (no sincronizado): " + i);
        }
    }
}
