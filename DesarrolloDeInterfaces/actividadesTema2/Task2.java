package actividadesTema2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Task2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField alumnoName;
	private JTextField asignaturaName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task2 frame = new Task2();
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
	public Task2() {
		setTitle("Calificar Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 393);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		alumnoName = new JTextField();
		alumnoName.setForeground(Color.BLACK);
		alumnoName.setBounds(24, 40, 283, 20);
		contentPane.add(alumnoName);
		alumnoName.setColumns(10);
		
		asignaturaName = new JTextField();
		asignaturaName.setToolTipText("");
		asignaturaName.setForeground(Color.BLACK);
		asignaturaName.setBounds(24, 104, 283, 20);
		contentPane.add(asignaturaName);
		asignaturaName.setColumns(10);
		
		JLabel nombreApellidos = new JLabel("Nombre y apellidos:");
		nombreApellidos.setBounds(24, 11, 169, 32);
		contentPane.add(nombreApellidos);
		
		JLabel Asignatura = new JLabel("Asignatura:");
		Asignatura.setBounds(24, 71, 134, 39);
		contentPane.add(Asignatura);
		
		JTextArea resultadoCalificacion = new JTextArea();
		resultadoCalificacion.setBounds(24, 152, 333, 160);
		contentPane.add(resultadoCalificacion);
		
		JButton Aprobar = new JButton("Aprobar");
		Aprobar.setForeground(Color.WHITE);
		Aprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultadoCalificacion.append(alumnoName.getText() + " ha aprobado la asignatura de " 
						+ asignaturaName.getText() + "\n");
			}
		});
		Aprobar.setBackground(Color.BLUE);
		Aprobar.setBounds(394, 152, 103, 45);
		contentPane.add(Aprobar);
		
		JButton Suspender = new JButton("Suspender");
		Suspender.setBackground(Color.RED);
		Suspender.setForeground(Color.WHITE);
		Suspender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			resultadoCalificacion.append(alumnoName.getText() + " ha suspendido la asignatura de "
					+  asignaturaName.getText() +"\n");
			}
		});
		Suspender.setBounds(394, 224, 103, 45);
		contentPane.add(Suspender);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			resultadoCalificacion.setText("");
			}
		});
		reset.setForeground(Color.WHITE);
		reset.setBackground(Color.LIGHT_GRAY);
		reset.setBounds(408, 311, 71, 32);
		contentPane.add(reset);
	}
}
