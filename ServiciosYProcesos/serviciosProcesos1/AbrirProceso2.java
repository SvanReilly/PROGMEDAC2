package serviciosProcesos1;

import java.io.IOException;
import java.util.Scanner;

public class AbrirProceso2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ruta del ejecutable de gle Cr
		String RUTA_PROCESO = "C:\\Program Files(x86)\\Google\\Chrome\\Application\\chrome.exe";
		// Creamos el proceso de Google Chrome
		ProcessBuilder pb = new ProcessBuilder(RUTA_PROCESO);
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
		System.exit(-1);
		}
	}

}
