package serviciosProcesos1;

import java.io.IOException;
import java.util.Scanner;

public class CerrarProceso2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*ProcessBuilder pb = new ProcessBuilder();
		Scanner teclado =new Scanner(System.in);
		
		try {
			Process process = pb.start();
			System.out.println("Terminar el proceso? (S/N)");
			
			if (teclado.nextLine().charAt(0)== 'S') {
				
			}
			
			//Destruir el proceso
			process.destroy();
	
		} catch (IOException ex) {
			// TODO: handle exception
		System.err.println("Error: " + ex.toString()); 
		
		}*/
		
		   // Ruta del ejecutable de gle Cr
        String RUTA_PROCESO = "C:\\Users\\AlumnoT\\AppData\\Local\\GitHubDesktop\\GitHubDesktop.exe";
        // Creamos el proceso de Google Chrome
        ProcessBuilder pb = new ProcessBuilder(RUTA_PROCESO);
        Process process = pb.start();
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Terminar el proceso? (S/N)");
        if (teclado.nextLine().charAt(0) == 'S') {

            // Destruimos el proceso
            System.out.println("Proceso terminado");
            process.destroyForcibly();
        }
        try {
            // Lanzamos el proceso
            // Obtenemos su estado de eje

            int retorno = process.waitFor();
            System.out.println("La ejecución de " + RUTA_PROCESO + " devuelve " + retorno);
        } catch (InterruptedException ex) {
            System.err.println("El proceso hijo finalizó de forma incorrecta");
            System.exit(-1);

        }

    }
	}


