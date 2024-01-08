package Tema10;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient {
    // Atributos estáticos y constantes
    private static final String HOST = "localhost";
    private static final int PUERTO = 6000;

    public static void main(String[] args) {
        // Crear instancia de ClienteTCP
    	TCPClient client = new TCPClient();
        // Llamar al método para establecer la conexión y recibir mensaje del servidor
        client.createConnectionGetMessagge();
    }

    // Constructor
    public TCPClient() {
        // No se requiere realizar acciones en el constructor
    }

    // Método para establecer la conexión y recibir mensaje del servidor
    public void createConnectionGetMessagge() {
        try {
            // Crear el socket cliente
            Socket skCliente = new Socket(HOST, PUERTO);

            // Obtener el flujo de entrada del socket cliente
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);

            // Imprimir mensaje recibido del servidor
            System.out.println("Mensaje recibido del servidor");

            // Imprimir el objeto flujo usando System.out.println() y el método readUTF()
            System.out.println(flujo.readUTF());

            // Cerrar el socket skCliente
            skCliente.close();
        } catch (IOException ex) {
            // Manejar excepciones en caso de error
            System.out.println("Error en el cliente: " + ex.toString());
        }
    }
}
