package Tema10;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    // Atributos estáticos y constantes
    private static final int PUERTO = 6000;
    private static final int MAX_CLIENTES = 3;

    public static void main(String[] args) {
        // Crear instancia de ServidorTCP
        TCPServer servidor = new TCPServer();
        // Llamar al método para iniciar el servidor
        servidor.ServerInit();
    }

    // Constructor
    public TCPServer() {
        // No se requiere realizar acciones en el constructor
    }

    // Método para iniciar el servidor
    public void ServerInit() {
        try {
            // Crear el socket servidor
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando en el puerto " + PUERTO);

            // Bucle for para aceptar hasta MAX_CLIENTES conexiones
            for (int numCli = 1; numCli <= MAX_CLIENTES; numCli++) {
                // Escuchar a un cliente
                Socket skCliente = skServidor.accept();
                System.out.println("Sirvo al cliente " + numCli);

                // Obtener el flujo de salida del cliente
                OutputStream aux = skCliente.getOutputStream();
                DataOutputStream flujo = new DataOutputStream(aux);

                // Mandar un mensaje al cliente
                flujo.writeUTF("Hola cliente " + numCli);

                // Cerrar el socket del cliente
                skCliente.close();
            }

            // Cerrar el socket del servidor
            skServidor.close();
        } catch (IOException e) {
            // Manejar excepciones en caso de error
            System.out.println(e.getMessage());
        }
    }
}
