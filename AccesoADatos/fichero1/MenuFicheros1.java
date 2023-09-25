package fichero1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MenuFicheros1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File fichero = new File("ficheroRandom.txt");
		Scanner sc = new Scanner(System.in);
		boolean menu = true;

		while (menu == true) {
			
			
            System.out.println("Bienvenido al Gestor de Ficheros Masónicos.");
            
            System.out.println(
              "1.- Crear fichero. "
            + "\n"
            + "2.- Borrar fichero."
            + "\n"
            + "3.- Mover fichero."
            + "\n"
            + "4.- Crear directorio."
            + "\n"
            + "5.- Leer fichero."
            + "\n"
            + "6.- Escribir fichero."
            + "\n"
            + "7.- Salir del programa.");

			System.out.println("\n" + "¿Qué desea hacer? Inserte un numero del 1-4, por favor:");
			String value = sc.next();

			switch (value) {
			case "1":
				System.out.println("\n\n\n"+ "Escriba el nombre del archivo a crear:"
						+ "\n");
				String name = sc.nextLine() + ".txt";
				File ficheroNuevo = new File (name);
				fichero.renameTo(ficheroNuevo);

				try {
					fichero.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "2":
				System.out.println("\n\n\n"
						+ "Escriba el nombre del archivo a borrar:"
						+ "\n");
				String buscarFichero= sc.nextLine();
				if (buscarFichero!=fichero.getName()) {
					System.out.println("No se ha encontrado el archivo a borrar. Pruebe otro nombre.");
				} else {
					fichero.delete();
				}
				break;

			case "3":
				File ficheroDestino = new File("clase1\\prueba.txt");

				try {

					if (fichero.renameTo(ficheroDestino)) {
						System.out.println("El fichero se ha movido con éxito."
								+ "\n\n");
					} else {
						System.out.println("El fichero no se ha podido mover."
								+ "\n\n");
					}

				} catch (Exception e) {
					e.printStackTrace();

				}

				break;
				
			case "4":
				
				System.out.println(""
						+ "Crear directorio.");
				break;
				
			case "5":
				
				System.out.println(""
						+ "Leer fichero.");
				break;
				
			case "6":
				
				System.out.println(""
						+ "Leer fichero.");
				break;
				
			case "7":
				
				System.out.println(""
						+ "Hasta pronto, iniciado.");
				menu = false;
				break;

			default:

				System.out.println("\n\n"
						+ "Por favor, elija de uno de los protocolos descritos en el menú, iniciado."
						+ "\n\n");
				menu = true;
			}

		}

	}

}

