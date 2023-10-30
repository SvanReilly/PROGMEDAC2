package actividadesTema4Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class CalendarioComponente extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7349056413879261570L;
	private int mes;
    private int año;
    private JButton btnAnterior, btnSiguiente;
    private JLabel lblMesAño;
    private JPanel panelDias;

    public CalendarioComponente() {
        // Inicializa el calendario con el mes y año actual
        Calendar calendario = Calendar.getInstance();
        mes = calendario.get(Calendar.MONTH) + 1; // Mes es 0-indexado
        año = calendario.get(Calendar.YEAR);

        // Diseño y layout del panel
        setLayout(new BorderLayout());

        // Panel superior con botones y etiqueta del mes y año
        JPanel panelSuperior = new JPanel();
        btnAnterior = new JButton("<<");
        btnSiguiente = new JButton(">>");
        lblMesAño = new JLabel();
        actualizarEtiquetaMesAño();
        panelSuperior.add(btnAnterior);
        panelSuperior.add(lblMesAño);
        panelSuperior.add(btnSiguiente);

        // Panel de los días
        panelDias = new JPanel(new GridLayout(0, 7)); // Cambio en el layout
        actualizarDias();

        // Añade componentes al panel
        add(panelSuperior, BorderLayout.NORTH);
        add(panelDias, BorderLayout.CENTER);

        // Añade ActionListener para los botones de navegación
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retrocederMes();
            }
        });

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avanzarMes();
            }
        });
    }

    private void actualizarEtiquetaMesAño() {
        String nombreMes = new DateFormatSymbols().getMonths()[mes - 1];
        lblMesAño.setText(nombreMes + " " + año);
    }

    private void actualizarDias() {
        panelDias.removeAll();
        String[] nombresDias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (String nombre : nombresDias) {
            JLabel lblDia = new JLabel(nombre, SwingConstants.CENTER);
            switch (lblDia.getText()) {
			case "Lunes":
				lblDia.setForeground(Color.BLACK);
				break;
			case "Martes":
				lblDia.setForeground(Color.BLUE);

				break;
			case "Miércoles":
				lblDia.setForeground(Color.CYAN);

				break;
			case "Jueves":
				lblDia.setForeground(Color.GREEN);

				break;
			case "Viernes":
				lblDia.setForeground(Color.ORANGE);

				break;
			case "Sábado":
				lblDia.setForeground(Color.PINK);

				break;
			case "Domingo":
				lblDia.setForeground(Color.MAGENTA);

				break;

			default:
				break;
			}
            panelDias.add(lblDia);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY); // Establece el Lunes como el primer día de la semana
        calendar.set(año, mes - 1, 1);

        int primerDia = calendar.get(Calendar.DAY_OF_WEEK);
        int ultimoDia = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Añade los espacios en blanco antes del primer día del mes
        for (int i = Calendar.MONDAY; i < primerDia; i++) {
            panelDias.add(new JLabel(""));
        }

        for (int i = 1; i <= ultimoDia; i++) {
            JButton btnDia = new JButton(String.valueOf(i));
            btnDia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Aquí puedes agregar la lógica para manejar la selección de un día
                    JOptionPane.showMessageDialog(null, "Has seleccionado el día " + btnDia.getText());
                }
            });
            panelDias.add(btnDia);
        }

        revalidate();
        repaint();
    }

    private void retrocederMes() {
        mes--;
        if (mes < 1) {
            mes = 12;
            año--;
        }
        actualizarEtiquetaMesAño();
        actualizarDias();
    }

    private void avanzarMes() {
        mes++;
        if (mes > 12) {
            mes = 1;
            año++;
        }
        actualizarEtiquetaMesAño();
        actualizarDias();
    }
// Test de funcionalidad para posterior implementacion en Interfaz3
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        CalendarioComponente calendario = new CalendarioComponente();
//        frame.getContentPane().add(calendario);
//        frame.setSize(400, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}