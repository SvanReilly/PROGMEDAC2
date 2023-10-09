package fichero2streamsFlujos;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class CasoPracticoLeerLista {

	public static void main(String[] args) {

		try {
			FileReader ficheroHTML = new FileReader("C:\\Users\\AlumnoT\\Desktop\\lista.html");
			StreamTokenizer tokenHTML = new StreamTokenizer(new BufferedReader(ficheroHTML));
			tokenHTML.parseNumbers();
			int contador =0;
			while (tokenHTML.nextToken() != StreamTokenizer.TT_EOF) {
				if (tokenHTML.ttype == StreamTokenizer.TT_NUMBER) {
					int edad = (int) tokenHTML.nval;
					contador++;
					if (contador>6) {
						System.out.print(edad);
					}
				} else if (tokenHTML.ttype == StreamTokenizer.TT_WORD && tokenHTML.sval.equals("años")) {
					System.out.print(" " + tokenHTML.sval + "\n");
				}
			}
			ficheroHTML.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}