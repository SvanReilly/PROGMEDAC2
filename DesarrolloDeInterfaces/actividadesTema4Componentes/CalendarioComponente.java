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
	private int month;
    private int year;
    private JButton btnAnterior, btnSiguiente;
    private JLabel lblYearMonth;
    private JPanel panelDias;

    public CalendarioComponente() {
        // Inicializa el calendario con el mes y a�o actual
        Calendar calendario = Calendar.getInstance();
        month = calendario.get(Calendar.MONTH) + 1; // Mes es 0-indexado
        year = calendario.get(Calendar.YEAR);

        // Dise�o y layout del panel
        setLayout(new BorderLayout());

        // Panel superior con botones y etiqueta del mes y a�o
        JPanel panelSuperior = new JPanel();
        btnAnterior = new JButton("<<");
        btnSiguiente = new JButton(">>");
        lblYearMonth = new JLabel();
        lblYearMonth.setFont(new Font("Times New Roman", Font.BOLD, 18));

        actualizarEtiquetaMonthYear();
        panelSuperior.add(btnAnterior);
        panelSuperior.add(lblYearMonth);
        panelSuperior.add(btnSiguiente);

        // Panel de los d�as
        panelDias = new JPanel(new GridLayout(0, 7)); // Cambio en el layout
        actualizarDias();

        // A�ade componentes al panel
        add(panelSuperior, BorderLayout.NORTH);
        add(panelDias, BorderLayout.CENTER);

        // A�ade ActionListener para los botones de navegaci�n
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

    private void actualizarEtiquetaMonthYear() {
        String nombreMes = new DateFormatSymbols().getMonths()[month - 1];
        lblYearMonth.setText(nombreMes + " " + year);
    }

    private void actualizarDias() {
        panelDias.removeAll();
        String[] nombresDias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        for (String nombre : nombresDias) {
            JLabel lblDia = new JLabel(nombre, SwingConstants.CENTER);
            switch (lblDia.getText()) {
			case "Lunes":
				lblDia.setForeground(Color.BLACK);
				break;
			case "Martes":
				lblDia.setForeground(Color.BLUE);

				break;
			case "Mi�rcoles":
				lblDia.setForeground(Color.CYAN);

				break;
			case "Jueves":
				lblDia.setForeground(Color.GREEN);

				break;
			case "Viernes":
				lblDia.setForeground(Color.ORANGE);

				break;
			case "S�bado":
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
        calendar.setFirstDayOfWeek(Calendar.MONDAY); // Establece el Lunes como el primer d�a de la semana
        calendar.set(year, month - 1, 1);

        int primerDia = calendar.get(Calendar.DAY_OF_WEEK);
        int ultimoDia = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // A�ade los espacios en blanco antes del primer d�a del mes
        for (int i = Calendar.MONDAY; i < primerDia; i++) {
            panelDias.add(new JLabel(""));
        }

        for (int i = 1; i <= ultimoDia; i++) {
            JButton btnDia = new JButton(String.valueOf(i));
            btnDia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Aqu� puedes agregar la l�gica para manejar la selecci�n de un d�a
                    JOptionPane.showMessageDialog(null, "Has seleccionado el dia " + btnDia.getText());
                }
            });
            panelDias.add(btnDia);
        }

        revalidate();
        repaint();
    }

    private void retrocederMes() {
        month--;
        if (month < 1) {
            month = 12;
            year--;
        }
        actualizarEtiquetaMonthYear();
        actualizarDias();
    }

    private void avanzarMes() {
        month++;
        if (month > 12) {
            month = 1;
            year++;
        }
        actualizarEtiquetaMonthYear();
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