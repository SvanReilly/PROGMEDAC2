package fichero1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuFicherosFinal {

	public static void main(String[] args)  {
		        Scanner scanner = new Scanner(System.in);

		        while (true) {
		            System.out.println("**************************************");
		            System.out.println("** MENU DE ARCHIVOS Y DIRECTORIOS   **");
		            System.out.println("**************************************");
		            System.out.println("** 1. Crear archivo                 **");
		            System.out.println("** 2. Mover archivo                 **");
		            System.out.println("** 3. Eliminar archivo              **");
		            System.out.println("** 4. Añadir info a un archivo      **"); 
		            System.out.println("** 5. Consultar info de un archivo  **");
		            System.out.println("** 6. Crear directorio              **"); 
		            System.out.println("** 7. Salir                         **");
		            System.out.println("**************************************");
		            System.out.println("Seleccione una opción:");

		            int opcion = scanner.nextInt();

		            switch (opcion) {
		                case 1:
		                    crearArchivo(scanner);
		                    break;
		                case 2:
		                    moverArchivo(scanner);
		                    break;
		                case 3:
		                    eliminarArchivo(scanner);
		                    break;
		                case 4:
		                    añadirInfoArchivo(scanner);
		                    break;
		                case 5:
		                    consultarInfoArchivo(scanner); 
		                    break;
		                case 6:
		                    crearDirectorio(scanner); 
		                    break;
		                case 7:
		                    System.out.println("Saliendo del programa.");
		                    scanner.close();
		                    break;
		                default:
		                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
		            }
		        }
		    }

		    // Método para crear un archivo.
		    private static void crearArchivo(Scanner scanner) {

		        // Solicitar nombre del archivo a crear.
		        System.out.println("Ingrese el nombre del archivo a crear:");
		        String nombreArchivo = scanner.next(); // Lee el nombre del archivo ingresado por el usuario.

		        try {
		            // Crea un objeto File con el nombre de archivo proporcionado.
		            File archivo = new File(nombreArchivo);

		            // Intenta crear el archivo.
		            if (archivo.createNewFile()) {
		                System.out.println("Archivo creado exitosamente."); 
		            } else {
		                System.out.println("El archivo ya existe."); 
		            }
		        } catch (IOException e) {
		            System.out.println("Error al crear el archivo"); // En caso de error 
		        }
		    }

		    // Método para mover un archivo a una nueva ubicación
		    private static void moverArchivo(Scanner scanner) {
		        
		        // Solicitar nombre del archivo a mover.
		        System.out.println("Ingrese el nombre del archivo a mover:");
		        String nombreArchivo = scanner.next(); // Lee el nombre del archivo ingresado por el usuario.

		        // Solicitar nueva ubicación del archivo.
		        System.out.println("Ingrese la nueva ubicación del archivo:");
		        String nuevaUbicacion = scanner.next(); // Lee la nueva ubicación ingresada por el usuario.

		        // Crea objetos File para representar el archivo y la nueva ubicación.
		        File archivo = new File(nombreArchivo);
		        File nuevaUbicacionDir = new File(nuevaUbicacion);

		        // Verifica si el archivo existe y es válido.
		        if (archivo.exists() && archivo.isFile()) {
		            // Verifica si la nueva ubicación es un directorio válido.
		            if (nuevaUbicacionDir.isDirectory()) {
		                // Crea un nuevo objeto File para representar el archivo en su nueva ubicación.
		                File nuevoArchivo = new File(nuevaUbicacionDir, archivo.getName());

		                // Intenta mover el archivo a la nueva ubicación.
		                if (archivo.renameTo(nuevoArchivo)) {
		                    System.out.println("Archivo movido exitosamente.");
		                } else {
		                    System.out.println("No se pudo mover el archivo."); // Error 
		                }
		            } else {
		                System.out.println("La nueva ubicación no es un directorio válido."); // Error mover archivo (ruta) pero archivo existe
		            }
		        } else {
		            System.out.println("El archivo no existe o no es válido."); // Error archivo no existe
		        }
		    }


		    // Método para eliminar un archivo
		    private static void eliminarArchivo(Scanner scanner) {
		        
		       // Solicitar nombre del archivo a borrar.
		        System.out.println("Ingrese el nombre del archivo a eliminar:");
		        String nombreArchivo = scanner.next(); // Lee el nombre del archivo ingresado por el usuario.

		        // Crea un objeto File para representar el archivo.
		        File archivo = new File(nombreArchivo);

		        // Verifica si el archivo existe y es un archivo válido.
		        if (archivo.exists() && archivo.isFile()) {
		            // Intenta eliminar el archivo.
		            if (archivo.delete()) {
		                System.out.println("Archivo eliminado exitosamente."); 
		            } else {
		                System.out.println("No se pudo eliminar el archivo."); // Error al eliminar (pero archivo existe)
		            }
		        } else {
		            System.out.println("El archivo no existe o no es válido."); // Error archivo no existe 
		        }
		    }


		    // Método para añadir información a un archivo en el sistema de archivos local.
		    private static void añadirInfoArchivo(Scanner scanner) {

		        // Solicitar el nombre del archivo al que desea añadir información.
		        System.out.println("Ingrese el nombre del archivo al que desea añadir información:");
		        String nombreArchivo = scanner.next(); // Lee el nombre del archivo ingresado por el usuario.

		        // Solicitar que ingrese la información que desea añadir.
		        System.out.println("Ingrese la información que desea añadir:");
		        String informacion = scanner.next(); // Lee la información ingresada por el usuario.

		        try {
		            // Abre el archivo en modo de escritura
		            FileWriter writer = new FileWriter(nombreArchivo, true);
		            
		            // Escribe la información en el archivo.
		            writer.write(informacion);
		            
		            // Cierra el archivo después de escribir.
		            writer.close();
		            
		            System.out.println("Información añadida exitosamente al archivo.");
		        } catch (IOException e) {
		            System.out.println("Error al añadir información al archivo"); // Error durante la escritura.
		        }
		    }


		    // Método para consultar la información de un archivo
		    private static void consultarInfoArchivo(Scanner scanner) {

		        // Solicitar el nombre del archivo al que desea consultar información.
		        System.out.println("Ingrese el nombre del archivo del que desea consultar información:");
		        String nombreArchivo = scanner.next(); // Lee el nombre del archivo ingresado por el usuario.

		        try {
		            // Crea un objeto File para representar el archivo.
		            File archivo = new File(nombreArchivo);

		            // Verifica si el archivo existe y es un archivo válido.
		            if (archivo.exists() && archivo.isFile()) {
		                // Abre el archivo para lectura utilizando un Scanner.
		                try (Scanner fileScanner = new Scanner(archivo)) {
		                    // Lee y muestra cada línea del archivo mientras haya más líneas disponibles.
		                    while (fileScanner.hasNextLine()) {
		                        String linea = fileScanner.nextLine();
		                        System.out.println(linea);
		                    }
		                }
		            } else {
		                System.out.println("El archivo no existe o no es válido."); // Error archivo no existe
		            }
		        } catch (IOException e) {
		            System.out.println("Error al leer el archivo"); // Error lectura
		        }
		    }


		    // Método para crear un directorio en la ubicación por defecto 
		    private static void crearDirectorio(Scanner scanner) {

		        // Solicitar el nombre del directorio 
		        System.out.println("Ingrese el nombre del directorio a crear:");
		        String nombreDirectorio = scanner.next(); // Lee el nombre del directorio ingresado por el usuario.

		        // Crea un objeto File para representar el directorio.
		        File directorio = new File(nombreDirectorio);

		        // Intenta crear el directorio en la ubicación actual.
		        if (directorio.mkdir()) {
		            System.out.println("Directorio creado exitosamente en la ubicación actual.");
		        } else {
		            System.out.println("El directorio ya existe o no se pudo crear."); // Error (ya existe o error de creación)
		        }
		    }

		}
