package ejemplovideo1;

public class SumadorActT3 {
	/**
	 * Este método suma todos los numeros que hay en un intervalo
	 * 
	 * @param numerol Inicio del intervalo
	 * @param numero2 Fin del intervalo
	 * @return Suma de todos los números que hay en el intervalo definido
	 */

	public static int sumar(int numerol, int numero2) {
		int suma = 0;
		for (int i = numerol; i < numero2; i++) {
			suma += i;
		}
		return suma;
	}

	public static void main(String[] args) {
		// Obtenemos los parámetros pasados al crear el proceso
		int numerol = Integer.valueOf(args[0]);
		int numero2 = Integer.valueOf(args[1]);

		int suma = sumar(numerol, numero2);
	}
}
