package actividadesTema4Componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class GeometriaComponente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> formasComboBox;
	private JPanel areaDibujo;

	public GeometriaComponente() {
		// Inicializar componentes
		String[] opcionesFormas = { "-------", "Triangulo", "Circulo", "Cuadrado" };
		formasComboBox = new JComboBox<>(opcionesFormas);
		formasComboBox.setPreferredSize(new Dimension(100, 30));
		formasComboBox.addActionListener(e -> {
			areaDibujo.repaint();
		});

		areaDibujo = new JPanel() {

			private static final long serialVersionUID = 7802746451434130408L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				String formaSeleccionada = (String) formasComboBox.getSelectedItem();
				switch (formaSeleccionada) {
				case "-------":
					noContent(g);
					break;
				case "Triangulo":
					dibujarTriangulo(g);
					break;
				case "Circulo":
					dibujarCirculo(g);
					break;
				case "Cuadrado":
					dibujarCuadrado(g);
					break;
				}
			}

			private void noContent(Graphics g) {
				g.setColor(Color.WHITE);
				int[] xPoints = { 0, 0, 0 };
				int[] yPoints = { 0, 0, 0 };
				g.fillPolygon(xPoints, yPoints, 0);
			}

			private void dibujarTriangulo(Graphics g) {
				int[] xPoints = { getWidth() / 2, getWidth() / 4, 3 * getWidth() / 4 };
				int[] yPoints = { getHeight() / 4, 3 * getHeight() / 4, 3 * getHeight() / 4 };
				int nPoints = 3;
				g.setColor(Color.BLACK);
				g.drawPolygon(xPoints, yPoints, nPoints);
				g.setColor(Color.RED);
				g.fillPolygon(xPoints, yPoints, 3);
			}

			private void dibujarCirculo(Graphics g) {
				int radio = Math.min(getWidth(), getHeight()) / 4;
				g.setColor(Color.BLACK);
				g.drawOval((getWidth() / 2 - radio) - 1, (getHeight() / 2 - radio) - 1, 2 * radio + 1, 2 * radio + 2);
				g.setColor(Color.CYAN);
				g.fillOval(getWidth() / 2 - radio, getHeight() / 2 - radio, 2 * radio, 2 * radio);
			}

			private void dibujarCuadrado(Graphics g) {
				int lado = Math.min(getWidth(), getHeight()) / 2;
				g.setColor(Color.BLACK);
				g.drawRect((getWidth() / 2 - lado / 2) - 1, (getHeight() / 2 - lado / 2) - 1, lado + 1, lado + 1);
				g.setColor(Color.GREEN);
				g.fillRect(getWidth() / 2 - lado / 2, getHeight() / 2 - lado / 2, lado, lado);
			}
		};

		setLayout(new BorderLayout());
		add(formasComboBox, BorderLayout.NORTH);
		add(areaDibujo, BorderLayout.CENTER);
		areaDibujo.setLayout(new GridLayout(0, 1, 0, 0));
	}
//	    public static void main(String[] args) {
//	        JFrame frame = new JFrame();
//	        frame.setTitle("Dibujar Formas Geométricas");
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        frame.setBounds(100, 100, 440, 440);
//	        frame.setContentPane(new FormasPanel());
//	        frame.setVisible(true);
//	    }
}
