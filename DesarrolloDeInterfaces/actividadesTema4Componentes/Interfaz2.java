package actividadesTema4Componentes;

import javax.swing.*;
import java.awt.*;

public class Interfaz2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hoya de la Mora - by Svan S. Reilly");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		// Agregar el paisaje a la ventana
		Paisaje paisaje = new Paisaje();
		frame.add(paisaje);

		frame.setVisible(true);
	}

}

class Paisaje extends JPanel {

	private static final long serialVersionUID = 1L;

//	public void paint(Graphics graph) {
//   	 super.paintComponent(graph);
//   	 Toolkit t = Toolkit.getDefaultToolkit();
//   	 Image i = t.getImage("emoji_lobo_reducido");
//   	 int ancho=(int)(t.getScreenSize().getWidth());
//   	 int alt=(int)(t.getScreenSize().getHeight());
//   	 graph.drawImage(i, 0, 0, ancho, alt, this);
//    }
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		Toolkit t = Toolkit.getDefaultToolkit();
//		Image i = t.getImage("emoji_lobo_reducido.png"); // Asegúrate de que el archivo "emoji_lobo_reducido.png" esté
//															// en la misma carpeta que tu código
//		int ancho = (int) (t.getScreenSize().getWidth());
//		int alt = (int) (t.getScreenSize().getHeight());

		// Cielo Nocturno
		g.setColor(new Color(15, 25, 255)); // Color azul claro
		g.fillRect(0, 0, getWidth(), getHeight() * 2 / 3); // 2/3 del panel es cielo

		// Luna llena
		g.setColor(Color.WHITE);
		g.fillOval(80, 50, 80, 80);

		// Nubes
		g.setColor(Color.GRAY);
		g.fillOval(330, 120, 80, 70);
		g.setColor(Color.GRAY);
		g.fillOval(370, 110, 80, 60);
		g.setColor(Color.GRAY);
		g.fillOval(400, 130, 90, 70);
		g.setColor(Color.GRAY);
		g.fillOval(450, 95, 80, 60);
		g.setColor(Color.GRAY);
		g.fillOval(480, 120, 80, 70);

		// Montañas
		g.setColor(new Color(139, 69, 19)); // Color marrón oscuro

		int[] xPoints1 = { 50, 250, 450 }; // Montaña 1
		int[] yPoints1 = { getHeight(), 200, getHeight() };

		int[] xPoints2 = { 100, 350, 600 }; // Montaña 2
		int[] yPoints2 = { getHeight(), 250, getHeight() };

		int[] xPoints3 = { 300, 550, 800 }; // Montaña 3
		int[] yPoints3 = { getHeight(), 150, getHeight() };

		g.fillPolygon(xPoints1, yPoints1, 3);
		g.fillPolygon(xPoints2, yPoints2, 3);
		g.fillPolygon(xPoints3, yPoints3, 3);

		// Pico nevado en montaña 3
		g.setColor(Color.WHITE);
		int[] xPoints4 = { 520, 550, 580 }; //
		int[] yPoints4 = { 200, 150, 200 };
		g.fillPolygon(xPoints4, yPoints4, 3);

		// Borreguil.
		g.setColor(new Color(34, 100, 34)); // Color verde oscuro
		g.fillRect(0, getHeight() * 2 / 3, getWidth(), getHeight() / 3); // 1/3 del panel es campo

	}
}
