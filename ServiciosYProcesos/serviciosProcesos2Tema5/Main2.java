package serviciosProcesos2Tema5;

public class Main2 {
	
    public static void main(String[] args) {
    	
        // Instancia de tres hilos de SimpleThread con diferentes prioridades
        SimpleThread hilo1 = new SimpleThread("hilo1", Thread.MIN_PRIORITY);
        SimpleThread hilo2 = new SimpleThread("hilo2", Thread.NORM_PRIORITY);
        SimpleThread hilo3 = new SimpleThread("hilo3", Thread.MAX_PRIORITY);

        // Inicio de los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
