package actividadesTema2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class Task2Extra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField calificacionNumber;
	private JTextField asignaturaName;
	private JTextField alumnoName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task2Extra frame = new Task2Extra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Task2Extra() {
		setTitle("Calificar Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(206, 206, 206));
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nombreApellidos = new JLabel("Nombre y apellidos:");
		nombreApellidos.setBounds(24, 11, 169, 32);
		contentPane.add(nombreApellidos);

		alumnoName = new JTextField();
		alumnoName.setForeground(Color.BLACK);
		alumnoName.setColumns(10);
		alumnoName.setBounds(24, 40, 283, 20);
		contentPane.add(alumnoName);

		JLabel asignatura = new JLabel("Asignatura:");
		asignatura.setBounds(24, 54, 134, 39);
		contentPane.add(asignatura);

		asignaturaName = new JTextField();
		asignaturaName.setToolTipText("");
		asignaturaName.setForeground(Color.BLACK);
		asignaturaName.setBounds(24, 87, 283, 20);
		contentPane.add(asignaturaName);
		asignaturaName.setColumns(10);

		JLabel calificacion = new JLabel("Calificación");
		calificacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		calificacion.setBounds(24, 104, 115, 32);
		contentPane.add(calificacion);

		calificacionNumber = new JTextField();
		calificacionNumber.setFont(new Font("Tahoma", Font.BOLD, 22));
		calificacionNumber.setForeground(Color.BLACK);
		calificacionNumber.setBounds(34, 134, 49, 48);
		contentPane.add(calificacionNumber);
		calificacionNumber.setColumns(10);

		JTextArea resultadoCalificacion = new JTextArea();
		resultadoCalificacion.setFont(new Font("Monospaced", Font.PLAIN, 10));
		resultadoCalificacion.setBackground(new Color(255, 255, 255));
		resultadoCalificacion.setBounds(24, 196, 454, 229);
		contentPane.add(resultadoCalificacion);

		JButton calificar = new JButton("Calificar");
		calificar.setBackground(Color.LIGHT_GRAY);
		calificar.setForeground(Color.BLACK);
		calificar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				double calificacion = Double.parseDouble(calificacionNumber.getText());
				
				try {

					if (calificacion >= 0 && calificacion < 5) { // Continuar desde aqui
						resultadoCalificacion.append(alumnoName.getText() + " ha suspendido la asignatura de "
								+ asignaturaName.getText() + " con un " + calificacionNumber.getText() + "\n");
					} else if (calificacion >= 5 && calificacion <= 10) {
						resultadoCalificacion.append(alumnoName.getText() + " ha aprobado la asignatura de "
								+ asignaturaName.getText() + " con un " + calificacionNumber.getText() + "\n");
					} else {
						System.out.println("Introduzca un valor entre 0 y 10 para la nota.");
					}
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "La calificación insertada no es de un formato válido, por favor, pruebe de nuevo.", "Error de formato", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		calificar.setBounds(350, 29, 101, 62);
		contentPane.add(calificar);

		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultadoCalificacion.setText("");
			}
		});
		reset.setForeground(Color.WHITE);
		reset.setBackground(Color.LIGHT_GRAY);
		reset.setBounds(364, 117, 71, 32);
		contentPane.add(reset);

	}
}
