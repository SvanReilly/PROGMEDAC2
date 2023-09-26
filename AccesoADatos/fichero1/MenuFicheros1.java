package fichero1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            + "5.- Escribir fichero."
            + "\n"
            + "6.- Leer fichero."
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
				System.out.print("Escriba el nombre del directorio a crear: ");
		        String nombreDirectorio = sc.nextLine();

		        // Ruta donde se creará el directorio
		        String url = "./"; // Ruta actual, puedes cambiarla según tus necesidades

		        // Intentar crear el directorio
		        File directorio = new File(url + nombreDirectorio);
		        boolean creado = directorio.mkdir();

		        if (creado) {
		            System.out.println("Directorio creado exitosamente.");
		        } else {
		            System.out.println("No se pudo crear el directorio.");
		        }

				break;
				
			case "5":
				System.out.print("Ingresa el nombre del archivo: ");
		        String nombreFichero2 = sc.nextLine();

		        System.out.print("Ingresa la ruta del directorio (o deja en blanco para usar la ruta actual): ");
		        String url2 = sc.nextLine();

		        // Si no se proporciona una ruta, usar la ruta actual
		        if (url2.isEmpty()) {
		            url2 = "./";
		        }

		        // Intentar escribir en el archivo
		        File archivo = new File(url2 + nombreFichero2);

		        try {
		            PrintWriter escritor = new PrintWriter(new FileWriter(archivo, true)); // El true indica que se agregará al archivo existente

		            System.out.println("Ingresa las líneas que deseas escribir en el archivo (escribe 'fin' para terminar):");
		            String linea;
		            while (true) {
		                linea = sc.nextLine();
		                if (linea.equals("fin")) {
		                    break;
		                }
		                escritor.println(linea);
		            }

		            escritor.close();
		            System.out.println("Contenido escrito en el archivo.");
		        } catch (IOException e) {
		            System.out.println("Error al escribir en el archivo: " + e.getMessage());
		        }
				break;
				
			case "6":
				System.out.print("Ingresa el nombre del archivo: ");
		        String nombreFichero3 = sc.nextLine();

		        System.out.print("Ingresa la ruta del directorio (o deja en blanco para usar la ruta actual): ");
		        String url3 = sc.nextLine();

		        // Si no se proporciona una ruta, usar la ruta actual
		        if (url3.isEmpty()) {
		            url3 = "./";
		        }

		        // Intentar leer el archivo
		        File ficheroALeer = new File(url3 + nombreFichero3);
		        
		        if (ficheroALeer.exists() && ficheroALeer.isFile()) {
		            try {
		                BufferedReader lector = new BufferedReader(new FileReader(ficheroALeer));
		                String linea;
		                while ((linea = lector.readLine()) != null) {
		                    System.out.println(linea);
		                }
		                lector.close();
		            } catch (IOException e) {
		                System.out.println("No es posible leer el fichero, iniciado. Aquí las razones: " + e.getMessage());
		            }
		        } else {
		            System.out.println("No existe un fichero válido con el nombre facilitado, iniciado.");
		        }
				break;
				
			case "7":
				
				System.out.println("Hasta pronto, iniciado.");
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

