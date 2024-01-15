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
			URI uri = new URI("http://www.youtube.com");

			// Convertimos la instancia a URL
			URL url = uri.toURL();

			// Abrimos la conexión
			URLConnection connection = url.openConnection();

			// Obtenemos el flujo de entrada del servidor
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// Leemos los datos de la respuesta
			String line;
			while ((line = reader.readLine()) != null) {
				// Procesamos la línea de la respuesta según tus necesidades
				System.out.println(line);
			}

			// Cerramos la conexión
			reader.close();
		} catch (Exception e) {
			// Capturamos cualquier excepción que pueda ocurrir durante el proceso
			e.printStackTrace();
		}

	}
}
