package serviciosProcesos1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ActividadesT3_1 {

	  public class Sumador{

	        public static int sumar(int numero1, int numero2){
	            int suma = 0; 
	            for(int i = numero1; i <=  numero2; i++){
	                suma +=i;
	            }
	            return suma;

	        }
	    }


	    public static void main(String[] args) {


	        Scanner teclado = new Scanner(System.in);
	        int numero1, numero2;


	        System.out.println("Dame un número:");
	        numero1 = teclado.nextInt();

	        System.out.println("Dame otro número:");
	        numero2 = teclado.nextInt();

	        try {
	            int estado_ejecucion = ejecutarClaseProceso(Sumador.class, numero1, numero2);

	            if (estado_ejecucion == 0) {
	                System.out.println("Proceso ejecutado correctamente.");
	            } else {
	                System.out.println("Error ejecutando el proceso.");
	            }

	        } catch (IOException | InterruptedException ex) {
	            System.err.println("Error: " + ex.toString());
	            System.exit(-1);
	        }
	    }


	    public static int ejecutarClaseProceso(Class<?> clase, int n1, int n2) throws IOException, InterruptedException {
	        String javaHome = System.getProperty("java.home");
	        String javaBin = javaHome 
	                + File.separator + "bin" 
	                + File.separator + "java";
	        String classpath = System.getProperty("java.class.path");
	        String className = clase.getCanonicalName();

	        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className, String.valueOf(n1), String.valueOf(n2));

	        Process process = builder.start();
	        return process.waitFor();
	    }
	}