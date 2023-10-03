package streamsFlujos;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class CasoPracticoPipes2 {
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader("Hola mi edad es 45.37"));

		try {
			while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
				if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
					System.out.print(streamTokenizer.sval + " ");
				} else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
					System.out.print((int) streamTokenizer.nval + " ");
				} else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
					System.out.print(". ");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
