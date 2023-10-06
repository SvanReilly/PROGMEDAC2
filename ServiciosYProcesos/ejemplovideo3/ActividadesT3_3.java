package ejemplovideo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ActividadesT3_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			
			// Se crea el proceso de hijo
			ProcessBuilder builder_echo = new ProcessBuilder ("CMD");
			Process proceso_echo = builder_echo.start();
			
			
			// Se indica cual es la salida del proceso hijo que ejecuta el bash
			final Scanner in = new Scanner (proceso_echo.getInputStream());
			new Thread() {
				@Override
				public void run() {
					while (in.hasNextLine()) {
						System.out.println(in.nextLine());
					}
				}
			}.start();
			
			// Se obtiene la salida del proceso hijo
			
			PrintWriter salida = new PrintWriter (proceso_echo.getOutputStream());
			
			// Se procede a realizar 10 llamadas al proceso hijo con el comando echo
			for (int i = 0; i<10; i++) {
				salida.println("echo Iteracion " + i);
				salida.flush();
			}
			// Y se cierran los flujos
			salida.close();
			
		} catch (IOException ex ) {
			System.err.println("Excepción de E/S!!: " + ex.toString());
		}
	}
	
}
