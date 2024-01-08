package Tema10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class UDPClient {
    // Atributos estáticos y constantes
    private static final int PUERTO = 6789;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        // Crear instancia de ClienteUDP
        UDPClient clienteUDP = new UDPClient();
        // Llamar al método para realizar la comunicación UDP
        clienteUDP.comunicacionUDP();
    }

    // Constructor
    public UDPClient() {
        // No se requiere realizar acciones en el constructor
    }

    // Método para realizar la comunicación UDP
    public void comunicacionUDP() {
        try {
            // Crear el objeto aleatorio
            Random aleatorio = new Random();

            // Generar un número aleatorio entre 1 y 100
            int numerocliente = aleatorio.nextInt(100) + 1;

            // Crear el mensaje que se enviará al servidor
            String mensajeenviar = String.valueOf(numerocliente);

            // Crear el socket UDP
            DatagramSocket socketUDP = new DatagramSocket();

            // Construir el datagrama para enviar el mensaje al servidor
            byte[] mensaje = mensajeenviar.getBytes();
            InetAddress hostServidor = InetAddress.getByName(HOST);
            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, PUERTO);
            socketUDP.send(peticion);

            // Construir el DatagramPacket que contendrá la respuesta
            byte[] buffer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);

            // Recibir la respuesta del servidor
            socketUDP.receive(respuesta);

            // Imprimir la respuesta del servidor en la salida estándar
            System.out.println("Respuesta: " + new String(respuesta.getData()).trim());

            // Cerrar el socket UDP
            socketUDP.close();
        } catch (IOException e) {
            // Manejar excepciones en caso de error
            System.out.println("Error: " + e.getMessage());
        }
    }
}
