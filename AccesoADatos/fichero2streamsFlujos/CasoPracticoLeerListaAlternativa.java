package fichero2streamsFlujos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class CasoPracticoLeerListaAlternativa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int edad;
			FileReader ficheroHTML = new FileReader("C:\\Users\\AlumnoT\\Desktop\\lista.html");
			StreamTokenizer tokenHTML = new StreamTokenizer(new BufferedReader(ficheroHTML));
			tokenHTML.parseNumbers();
			while (tokenHTML.nextToken() != StreamTokenizer.TT_EOF) {
				if (tokenHTML.ttype == StreamTokenizer.TT_NUMBER) {
						edad = (int) tokenHTML.nval;
					if (tokenHTML.nextToken() == StreamTokenizer.TT_WORD && tokenHTML.sval.equals("años")) {
						System.out.print(edad + " " + tokenHTML.sval + "\n");
					}
				} else if (tokenHTML.nextToken() == StreamTokenizer.TT_EOF) {
					char[] spoiler = {'G','o','j','o',' ','S','a','t','o','r','u',' ','h','a','s',' ','d','i','e','d','.'};
					
					System.out.print(spoiler);
				}
			}
			ficheroHTML.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


