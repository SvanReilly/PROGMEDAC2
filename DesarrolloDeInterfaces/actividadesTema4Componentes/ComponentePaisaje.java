package actividadesTema4Componentes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ComponentePaisaje extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ComponentePaisaje() {
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		dibujarCieloNocturno(g);
		dibujarLunaLlena(g);
		dibujarMontes(g);
		dibujarPicoNevado(g);
		dibujarBorreguil(g);
		dibujarNubes(g);
}
		protected void dibujarCieloNocturno(Graphics g) {
			super.paintComponents(g);
			// Cielo Nocturno
			g.setColor(new Color(15, 25, 255)); // Color azul claro
			g.fillRect(0, 0, getWidth(), getHeight() * 2 / 3); // 2/3 del panel es cielo
		}
		
		protected void dibujarLunaLlena (Graphics g) {
			super.paintComponents(g);
			// Luna llena
			g.setColor(Color.WHITE);
			g.fillOval(80, 50, 80, 80);
		}
		
		protected void dibujarNubes(Graphics g) {
			super.paintComponents(g);
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
		}
		
		protected void dibujarMontes(Graphics g) {
			super.paintComponents(g);
			// Monta�as
			g.setColor(new Color(139, 69, 19)); // Color marr�n oscuro

			int[] xPoints1 = { 50, 250, 450 }; // Monta�a 1
			int[] yPoints1 = { getHeight(), 200, getHeight() };

			int[] xPoints2 = { 100, 350, 600 }; // Monta�a 2
			int[] yPoints2 = { getHeight(), 250, getHeight() };

			int[] xPoints3 = { 300, 550, 800 }; // Monta�a 3
			int[] yPoints3 = { getHeight(), 150, getHeight() };

			g.fillPolygon(xPoints1, yPoints1, 3);
			g.fillPolygon(xPoints2, yPoints2, 3);
			g.fillPolygon(xPoints3, yPoints3, 3);
		}
		
		protected void dibujarPicoNevado(Graphics g) {
			super.paintComponents(g);
			// Pico nevado en monta�a 3
			g.setColor(Color.WHITE);
			int[] xPoints4 = { 520, 550, 580 }; //
			int[] yPoints4 = { 200, 150, 200 };
			g.fillPolygon(xPoints4, yPoints4, 3);
		}
		protected void dibujarBorreguil(Graphics g) {
			super.paintComponents(g);
			g.setColor(new Color(34, 100, 34)); // Color verde oscuro
			g.fillRect(0, getHeight() * 2 / 3, getWidth(), getHeight() / 3);
		}

	}


