package serviciosProcesos1;

import java.io.IOException;

public class AbrirProceso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Ruta del ejecutable de gle Cr
		String RUTA_PROCESO = "C:\\Users\\AlumnoT\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
		// Creamos el proceso de Google Chrome
		ProcessBuilder pb = new ProcessBuilder(RUTA_PROCESO);
		try {
			// Lanzamos el proceso
			Process process = pb.start();
			// Obtenemos su estado de eje

			int retorno = process.waitFor();
			System.out.println("La ejecución de " + RUTA_PROCESO + " devuelve " + retorno);
		} catch (IOException ex) {
			System.err.println("Error: " + ex.toString());
			System.exit(-1);
		} catch (InterruptedException ex) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
			System.exit(-1);

		}
	}
}
