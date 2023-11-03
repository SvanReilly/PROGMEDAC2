package actividadesTema4Componentes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Interfaz1 extends JFrame implements ActionListener {

    private GeometriaComponente geometriaComponente;
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

        // Creamos una instancia de GeometriaComponente
        geometriaComponente = new GeometriaComponente();

        contentPane.setLayout(new BorderLayout());

        // Agregamos la instancia de GeometriaComponente al contentPane
        contentPane.add(geometriaComponente, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        geometriaComponente.repaint(); // Vuelve a dibujar la forma cuando se selecciona una opci�n
    }
}
