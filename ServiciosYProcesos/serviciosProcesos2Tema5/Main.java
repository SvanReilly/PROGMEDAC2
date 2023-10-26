package serviciosProcesos2Tema5;


public class Main {
    
    public static void main(String[] args) throws InterruptedException {
    	
        // Booleano para gestionar la sincronizacion
        boolean sincronizado = false;

        // Instanciar objeto Counter con el valor de sincronizacion establecido
        Counter counter = new Counter(sincronizado);

        // Instancia de dos hilos de conteo junto con sus paramentros
        CountingThread h1 = new CountingThread(1, 5, counter);
        CountingThread h2 = new CountingThread(2, 5, counter);

        // Inicio de los hilos
        h1.start();
        h2.start();

        // Cuando ambos hilos finalizan su tarea
        h1.join();
        h2.join();

        // Mensaje de finalizacion para la ejecucion
        System.out.println("Ejecucion finalizada");

        // Establece el valor del booleano a true
        sincronizado = true;
        counter = new Counter(sincronizado);

        // Instancia de nuevos hilos con el nuevo objeto Counter
        h1 = new CountingThread(1, 5, counter);
        h2 = new CountingThread(2, 5, counter);

        // Inicio de los nuevos hilos
        h1.start();
        h2.start();

        // Cuando ambos hilos finalizan su tarea
        h1.join();
        h2.join();

     // Mensaje de finalizacion para la ejecucion
        System.out.println("Ejecucion finalizada");
    }
}
