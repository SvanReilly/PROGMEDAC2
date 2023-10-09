package fichero1Basics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuFicherosFinal {
	public static void main(String[] args) {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_PURPLE = "\u001B[35m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_LIGHT_YELLOW = "\u001B[93m";
		final String ANSI_BLINK = "\u001B[5m";
		final String ANSI_LIGHT_PURPLE  = "\033[1;35m";
		final String ANSI_BROWN = "\033[0;33m";

		Scanner sc = new Scanner(System.in);
		boolean menu = true;
		while (menu) {

			System.out.println(ANSI_CYAN + "BIENVENIDO AL GESTOR DE FICHEROS MASÓNICOS." + ANSI_RESET);

			System.out.println(ANSI_GREEN + "1.- Crear fichero. " + ANSI_RESET 
			+ "\n" 
			+ ANSI_RED + "2.- Borrar fichero." + ANSI_RESET 
			+ "\n" 
			+ ANSI_PURPLE + "3.- Mover fichero." + ANSI_RESET
			+ "\n"
			+ ANSI_LIGHT_YELLOW + "4.- Crear directorio." + ANSI_RESET
			+ "\n" 
			+ ANSI_CYAN + "5.- Escribir en fichero." + ANSI_RESET
			+ "\n" 
			+ ANSI_LIGHT_PURPLE + "6.- Leer fichero." + ANSI_RESET
			+ "\n"
			+ ANSI_BROWN + "7.- Salir del programa." + ANSI_RESET
			+ "\n");
			
			System.out.println(ANSI_BLINK + "¿Qué desea hacer? Inserte un numero del 1-7, por favor: " + ANSI_RESET);
			String value = sc.next();

			switch (value) {
			
			case "1":
				System.out.println("Escriba el nombre del archivo a crear (junto con su extensión o formato):");
				String nombreArchivo1 = sc.next();

				try {
					File archivo1 = new File(nombreArchivo1);
					if (archivo1.createNewFile()) {
						System.out.println("Archivo o fichero creado con exito.");
					} else {
						System.out.println("El archivo o fichero ya existe.");
					}
				} catch (IOException e) {
					System.out.println("No fue posible crear el archivo o fichero");
				}
				break;
				
			case "2":

				System.out.println("Escriba el nombre del archivo o fichero a eliminar, iniciado:");
				String nombreArchivo3 = sc.next();
				File archivo3 = new File(nombreArchivo3);

				if (archivo3.exists() && archivo3.isFile()) {

					if (archivo3.delete()) {
						System.out.println("Archivo eliminado exitosamente.");
					} else {
						System.out.println("No se pudo eliminar el archivo.");
					}
				} else {
					System.out.println("El archivo no existe o no es válido.");
				}
				break;
				
			case "3":

				System.out.println("Escriba el nombre del archivo que desee mover (junto con su extensión o formato):");
				String nombre2 = sc.next();
				File archivo2 = new File(nombre2);

				System.out.println("Escriba el nombre del nuevo directorio:");
				String nuevaUbicacion = sc.next();
				File nuevoDirectorio = new File(nuevaUbicacion);

				if (archivo2.exists() && archivo2.isFile()) {
					if (nuevoDirectorio.isDirectory()) {
						File nuevoArchivo2 = new File(nuevoDirectorio, archivo2.getName());

						if (archivo2.renameTo(nuevoArchivo2)) {
							System.out.println("Se movio con éxito el archivo.");
						} else {
							System.out.println("No se pudo mover el archivo.");
						}
					} else {
						System.out.println("No es un directorio válido.");
					}
				} else {
					System.out.println("El archivo no existe o no es válido.");
				}
				break;

			case "4":

				System.out.println("Escriba un nombre para crear el directorio, iniciado: ");
				String nombreDirectorio = sc.next();
				File directorio = new File(nombreDirectorio);

				if (directorio.mkdir()) {
					System.out.println("El directorio fue creado con éxito en la ubicación actual.");
				} else {
					System.out.println("El directorio ya existe o no se pudo crear, iniciado.");
				}
				break;
				
				
			case "5":

				System.out.println("Ingrese el nombre del archivo al que desea añadir información:");
				String nombreArchivo4 = sc.next();
				System.out.println("Escriba el contenido que desee incluir en el fichero:");
				String limpiarCache= sc.nextLine();
				String contenido = sc.nextLine();

				try {
					FileWriter escribir = new FileWriter(nombreArchivo4, true);
					escribir.write(contenido);
					escribir.close();
			
					System.out.println("Contenido agregado al fichero.");
				} catch (IOException e) {
					System.out.println("No fue posible agregar el contenido facilitado al fichero.");
				}
				break;
			
			case "6":

				System.out.println("Ingrese el nombre del archivo del que desea consultar información:");
				String nombreArchivo5 = sc.next();

				try {
					File archivo5 = new File(nombreArchivo5);
					if (archivo5.exists() && archivo5.isFile()) {
						try (Scanner fileScanner = new Scanner(archivo5)) {
							while (fileScanner.hasNextLine()) {
								String linea = fileScanner.nextLine();
								System.out.println(linea);
							}
						}
					} else {
						System.out.println("El archivo no existe o no es válido.");
					}
				} catch (IOException e) {
					System.out.println("No fue posible leer el contenido del fichero.");
				}
				break;

			case "7":
				System.out.println(ANSI_CYAN + "Hasta pronto, iniciado." + ANSI_RESET);
				menu = false;

				break;
			default:
				System.out.println(
						"\n\n" + ANSI_RED + "Por favor, elija de uno de los protocolos descritos en el menú, iniciado." + ANSI_RESET + "\n\n");
				menu = true;
			}
		}
	}
}
