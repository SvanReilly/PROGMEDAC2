package serviciosProcesos2Tema5;

// SimpleThread extiende de Thread
class SimpleThread extends Thread {
	
    // Constructor con parametros que recibe un nombre y una prioridad
    public SimpleThread(String name, int priority) {
        super(name); // Constructor de la clase base Thread con el nombre dado
        setPriority(priority); // Establece la prioridad del hilo instanciado.
    }

    // Run: se ejecuta cuando el hilo comienza a funcionar
    @Override
    public void run() {
        // Imprime el nombre y la prioridad del hilo
        System.out.println("Hilo: " + getName() + ", Prioridad: " + getPriority());
    }
}
