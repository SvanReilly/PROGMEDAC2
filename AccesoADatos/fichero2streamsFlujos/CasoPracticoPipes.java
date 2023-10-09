package fichero2streamsFlujos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class CasoPracticoPipes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		final PipedOutputStream salida = new PipedOutputStream();
		final PipedInputStream entrada = new PipedInputStream(salida);
		
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
		


		Thread thread1 = new Thread(new Runnable() {
			@Override
			
			public void run() {
				
				System.out.println("Ingrese el nombre del archivo del que desea consultar información:");
				String nombreArchivo5 = sc.next();
				try {
					File archivo5 = new File(nombreArchivo5);
					if (archivo5.exists() && archivo5.isFile()) {
						try (Scanner fileScanner = new Scanner(archivo5)) {
							while (fileScanner.hasNextLine()) {
								String linea = fileScanner.nextLine();
					
								salida.write(linea.getBytes());
							}
						}
					}else {
						System.out.println("El archivo no existe o no es válido.");
				}
				}catch (IOException e) {
					System.out.println("No fue posible leer el contenido del fichero.");
				}
			}
		});
		
		
		Thread thread2 = new Thread(new Runnable() {
			 public void run() {
				 try {
					int unByte=entrada.read();
					while(unByte!=-1) {
						System.out.print((char)unByte);
						unByte = entrada.read();
					}
				} catch (IOException e) {
					// TODO: handle exception
				}
			 }
		});

		
		thread1.start();
		thread2.start();
	}

}
