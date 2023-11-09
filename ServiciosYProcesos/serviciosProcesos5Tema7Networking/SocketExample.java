package serviciosProcesos5Tema7Networking;

import java.io.*;
import java.net.*;

public class SocketExample {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";  // Dirección IP del servidor
        int serverPort = 12345;               // Puerto del servidor

        try {
            // Crea un socket y se conecta al servidor
            Socket socket = new Socket(serverAddress, serverPort);

            // Abre flujos de entrada y salida para la comunicación con el servidor
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            // Envía un mensaje al servidor
            writer.println("¡Hola, servidor!");

            // Lee la respuesta del servidor
            String response = reader.readLine();
            System.out.println("Respuesta del servidor: " + response);

            // Cierra los flujos y el socket
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            // Manejo de excepción en caso de problemas de conexión
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}