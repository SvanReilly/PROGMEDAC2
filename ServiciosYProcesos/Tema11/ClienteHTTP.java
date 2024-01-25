package Tema11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class ClienteHTTP {
	public static void main(String[] args) {

		try {
			// Creamos la instancia URI
<<<<<<< Updated upstream
			URI uri = new URI("https://www.youtube.com");
=======
			URI uri = new URI("https://es.tradingview.com/");
>>>>>>> Stashed changes

			// Convertimos la instancia a URL
			URL url = uri.toURL();

			// Abrimos la conexion
			URLConnection connection = url.openConnection();

			// Obtenemos el flujo de entrada del servidor
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// Leemos los datos de la respuesta
			String line;
			while ((line = reader.readLine()) != null) {
				// Procesamos la linea de la respuesta segun tus necesidades
				System.out.println(line);
			}

			// Cerramos la conexion
			reader.close();
		} catch (Exception e) {
			// Capturamos cualquier excepcion que pueda ocurrir durante el proceso
			e.printStackTrace();
		}

	}
}
