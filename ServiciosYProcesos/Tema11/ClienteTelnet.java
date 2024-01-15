package Tema11;

import org.apache.commons.net.telnet.TelnetClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClienteTelnet {
	public static void main(String[] args) {

		TelnetClient telnetCliente = new TelnetClient();

        try {
            // Creamos un objeto telnetCliente usando el constructor por defecto
            TelnetClient telnetClient = new TelnetClient();

            // Realizamos la conexión Telnet
            telnetClient.connect("telehack.com", 23);

            // Obtenemos los flujos de comunicación
            InputStream inputStream = telnetClient.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Imprimimos cada línea de contenido del servidor
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Desconectamos el servidor Telnet
            telnetClient.disconnect();
        } catch (IOException e) {
            // Capturamos cualquier excepción que pueda ocurrir durante el proceso
            e.printStackTrace();
        }


	}

}
