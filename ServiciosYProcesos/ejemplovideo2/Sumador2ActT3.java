package ejemplovideo2;

public class Sumador2ActT3 {

	/**
	 * Esta clase sumará todos iso números entre dos números
	 * 
	 * @author Alejandro Ortega
	 */

	public class Sumador {
		/**
		 * Este método suma todos los números que hay en un intervalo
		 * 
		 * @param numerol Inicio del intervalo
		 * @param numero2 Fin del intervalo
		 * @return suma de todos los números que hay en el intervalo definido
		 * 
		 */
		public static int sumar(int numero1, int numero2) {

			int suma = 0;
			for (int i = numero1; i <= numero2; i++) {
				suma += i;
			}
			return suma;
		}

		public static void main(String[] args) {
			// Obtener los parámetros pasados al crear el proceso
			int numero1 = Integer.valueOf(args[0]);
			int numero2 = Integer.valueOf(args[1]);
			System.out.println("Sumo desde " + numero1 + " hasta " + numero2 + ": ");
			System.out.println(sumar(numero1, numero2));
		}
	}
}
