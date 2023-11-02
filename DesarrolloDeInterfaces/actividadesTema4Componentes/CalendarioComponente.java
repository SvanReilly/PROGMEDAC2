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
    private JLabel lblMonth;
    private JLabel lblYear;
    private JPanel panelDias;
    private JButton btnAnterior_1;
    private JButton btnSiguiente_1;
    JButton btnDia = new JButton();
    JDialog recordatorioDialog;
    


	public CalendarioComponente() {
        // Inicializa el calendario con el mes y a�o actual
        Calendar calendario = Calendar.getInstance();
        month = calendario.get(Calendar.MONTH) + 1; // Mes es 0-indexado
        year = calendario.get(Calendar.YEAR);

        // Dise�o y layout del panel
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(10);
        borderLayout.setVgap(10);
        setLayout(borderLayout);

        // Panel superior con botones y etiqueta del mes y a�o
        JPanel panelSuperior = new JPanel();
        btnAnterior = new JButton("<<");
        btnSiguiente = new JButton(">>");
        lblMonth = new JLabel();
        lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonth.setFont(new Font("Times New Roman", Font.BOLD, 18));

        actualizarEtiquetaMonth();
        panelSuperior.setLayout(new GridLayout(0, 3, 50, 10));
        panelSuperior.add(btnAnterior);
        panelSuperior.add(lblMonth);
        panelSuperior.add(btnSiguiente);

        // Panel de los d�as
        panelDias = new JPanel(new GridLayout(0, 7)); // Cambio en el layout
        actualizarDias();

        // A�ade componentes al panel
        add(panelSuperior, BorderLayout.NORTH);
        
        btnAnterior_1 = new JButton("<<");
        btnAnterior_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		retrocederrYear();
        	}
        });
        panelSuperior.add(btnAnterior_1);
        
        lblYear = new JLabel();
        lblYear.setText("2023");
        lblYear.setHorizontalAlignment(SwingConstants.CENTER);
        lblYear.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panelSuperior.add(lblYear);
        
        btnSiguiente_1 = new JButton(">>");
        btnSiguiente_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		avanzarYear();
        	}
        });
        panelSuperior.add(btnSiguiente_1);
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

    private void actualizarEtiquetaMonth() {
        String nombreMes = new DateFormatSymbols().getMonths()[month - 1];
        lblMonth.setText(nombreMes);
    }
    private void actualizarEtiquetaYear() {
    	lblYear.setText("" + year + "");
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
			case "Miercoles":
				lblDia.setForeground(Color.CYAN);

				break;
			case "Jueves":
				lblDia.setForeground(Color.GREEN);

				break;
			case "Viernes":
				lblDia.setForeground(Color.ORANGE);

				break;
			case "Sabado":
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
            btnDia = new JButton(String.valueOf(i));
            String diaActual = btnDia.getText();
            btnDia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Aqu� puedes agregar la l�gica para manejar la selecci�n de un d�a
            		try {
            			recordatorioDialog dialog = new recordatorioDialog(diaActual, lblMonth.getText(), lblYear.getText());
            			dialog.setTitle("Establecer recordatorio para el " + diaActual + " de " + lblMonth.getText()+ " del " + lblYear.getText());
            			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            			dialog.setVisible(true);
            			
            		} catch (Exception e1) {
            			e1.printStackTrace();
            		}
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
        actualizarEtiquetaMonth();
    	actualizarEtiquetaYear();
        actualizarDias();
    }

    private void avanzarMes() {
        month++;
        if (month > 12) {
            month = 1;
            year++;
        }
        actualizarEtiquetaMonth();
    	actualizarEtiquetaYear();
        actualizarDias();
    }
    
    private void retrocederrYear() { //por hacer, separar el valor de los años del lblYearMonth y agregar dos botones mas encima de los meses para saltar los años.
    	year--;
    	actualizarEtiquetaYear();
    	actualizarDias();
    }
    
    private void avanzarYear() {
    	year ++;
    	actualizarEtiquetaYear();
    	actualizarDias();
    }	

}

