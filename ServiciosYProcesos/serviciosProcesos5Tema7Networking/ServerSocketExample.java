package serviciosProcesos5Tema7Networking;


import java.io.*;
import java.net.*;

public class ServerSocketExample {
    public static void main(String[] args) {
        int serverPort = 12345;  // Puerto en el que el servidor escuchará

        try {
            // Crea un ServerSocket que escucha en el puerto especificado
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Servidor escuchando en el puerto " + serverPort);

            // Espera una conexión de un cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

            // Abre flujos de entrada y salida para la comunicación con el cliente
            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            InputStream in = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            // Lee un mensaje del cliente
            String message = reader.readLine();
            System.out.println("Mensaje del cliente: " + message);

            // Envía una respuesta al cliente
            writer.println("Hola, cliente. ¿Qué tal va todo en el mundo físico?");

            // Cierra los flujos y los sockets
            writer.close();
            reader.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            // Manejo de excepción en caso de problemas de conexión
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}