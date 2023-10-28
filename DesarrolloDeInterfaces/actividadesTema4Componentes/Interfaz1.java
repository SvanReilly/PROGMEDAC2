package actividadesTema4Componentes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Interfaz1 extends JFrame implements ActionListener {

    private JComboBox<String> formasComboBox;
    private JPanel areaDibujo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz1 frame = new Interfaz1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interfaz1() {
        setTitle("Dibujar Formas Geom\u00E9tricas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 440, 440);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // Inicializar componentes
        String[] opcionesFormas = {"-------", "Triángulo", "Círculo", "Cuadrado"};
        formasComboBox = new JComboBox<>(opcionesFormas);
        formasComboBox.setPreferredSize(new Dimension(100, 30)); // Ajusta el tamaño del JComboBox
        formasComboBox.addActionListener(this);

        areaDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibuja la forma seleccionada
                String formaSeleccionada = (String) formasComboBox.getSelectedItem();
                switch (formaSeleccionada) {
                    case "-------":
                        noContent(g);
                        break;
                    case "Triángulo":
                        dibujarTriangulo(g);
                        break;
                    case "Círculo":
                        dibujarCirculo(g);
                        break;
                    case "Cuadrado":
                        dibujarCuadrado(g);
                        break;
                }
            }

            private void noContent(Graphics g) {
                g.setColor(Color.WHITE);
                int[] xPoints = {0, 0, 0};
                int[] yPoints = {0, 0, 0};
                g.fillPolygon(xPoints, yPoints, 0);
            }

            private void dibujarTriangulo(Graphics g) {
                int[] xPoints = {getWidth() / 2, getWidth() / 4, 3 * getWidth() / 4};
                int[] yPoints = {getHeight() / 4, 3 * getHeight() / 4, 3 * getHeight() / 4};
                int nPoints = 3;
                g.setColor(Color.BLACK);
                g.drawPolygon(xPoints, yPoints, nPoints);
                g.setColor(Color.RED);
                g.fillPolygon(xPoints, yPoints, 3);
            }

            private void dibujarCirculo(Graphics g) {
                int radio = Math.min(getWidth(), getHeight()) / 4;
                g.setColor(Color.BLACK);
                g.drawOval((getWidth() / 2 - radio) -1, (getHeight() / 2 - radio)-1, 2 * radio+1, 2 * radio+2);
                g.setColor(Color.CYAN);
                g.fillOval(getWidth() / 2 - radio, getHeight() / 2 - radio, 2 * radio, 2 * radio);
            }

            private void dibujarCuadrado(Graphics g) {
                int lado = Math.min(getWidth(), getHeight()) / 2;
                g.setColor(Color.BLACK);
                g.drawRect((getWidth() / 2 - lado / 2)-1, (getHeight() / 2 - lado  / 2)-1, lado+1, lado +1);
                g.setColor(Color.GREEN);
                g.fillRect(getWidth() / 2 - lado / 2, getHeight() / 2 - lado  / 2, lado, lado);
            }
        };

       
        contentPane.setLayout(new BorderLayout());

        // Agregar componentes al contentPane
        contentPane.add(formasComboBox, BorderLayout.NORTH);
        contentPane.add(areaDibujo, BorderLayout.CENTER);
        areaDibujo.setLayout(new GridLayout(0, 1, 0, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        areaDibujo.repaint(); // Vuelve a dibujar la forma cuando se selecciona una opción
    }
}
