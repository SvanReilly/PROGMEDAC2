package fichero1;

import java.io.File;
import java.io.IOException;

public class Clase1Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hola mundo");

		File fichero = new File("prueba.txt");

		// CREAR FICHEROS//
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// BORRAR FICHEROS//
		// fichero.delete();

		// DESPLAZAR FICHEROS//
		File ficheroDestino = new File("clase1\\prueba.txt");

		try {
			if (fichero.renameTo(ficheroDestino)) {
				System.out.println("El fichero se ha movido con éxito.");
			} else {
				System.out.println("El fichero no se ha podido mover.");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
