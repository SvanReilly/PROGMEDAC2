package actividadesTema4Componentes;

import javax.swing.*;
import java.awt.*;

public class Interfaz2 extends JFrame {
	public Interfaz2() {
		getContentPane().setLayout(new BorderLayout(0, 0));
	}

	private static final long serialVersionUID = -3035937533607109831L;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hoya de la Mora - by Svan S. Reilly");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		// Agregar el paisaje a la ventana
	
		ComponentePaisaje paisaje = new ComponentePaisaje();
		frame.getContentPane().add(paisaje);

		frame.setVisible(true);
	}

}
