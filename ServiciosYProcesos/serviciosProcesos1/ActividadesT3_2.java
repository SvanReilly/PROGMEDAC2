package serviciosProcesos1;

import java.io.IOException;
import java.util.Scanner;

public class ActividadesT3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			
			// Creamos el proceso de hijo
			ProcessBuilder builder_echo = new ProcessBuilder ("CMD");
			Process proceso_echo = builder_echo.start();
			
			
			// Indicamos cual es la salida del proceso hijo que ejecuta el bash
			final Scanner in = new Scanner (proceso_echo.getInputStream());
			new Thread() {
				@Override
				public void run() {
					while (in.hasNextLine()) {
						System.out.println(in.nextLine());
					}
				}
			}.start();
			
		} catch (IOException | InterruptedException ex ) {
			
		}
	}

}
