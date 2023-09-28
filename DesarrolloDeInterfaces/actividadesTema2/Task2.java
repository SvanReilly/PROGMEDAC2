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
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_BLACK = "\u001B[30m";
	final String ANSI_RED = "\u001B[31m";
	final String ANSI_GREEN = "\u001B[32m";
	final String ANSI_YELLOW = "\u001B[33m";
	final String ANSI_BLUE = "\u001B[34m";
	final String ANSI_PURPLE = "\u001B[35m";
	final String ANSI_CYAN = "\u001B[36m";
	final String ANSI_WHITE = "\u001B[37m";
	final String ANSI_LIGHT_YELLOW = "\u001B[93m";
	final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	final String ANSI_BOLD = "\u001B[1m";
	final String ANSI_UNBOLD = "\u001B[21m";
	final String ANSI_UNDERLINE = "\u001B[4m";
	final String ANSI_STOP_UNDERLINE = "\u001B[24m";
	final String ANSI_BLINK = "\u001B[5m";
	
	final String ANSI_LIGHT_BLUE =  "\033[1;34m";
	final String ANSI_LIGHT_CYAN  = "\033[1;36m";
	final String ANSI_LIGHT_GREEN  = "\033[1;32m";
	final String ANSI_LIGHT_PURPLE  = "\033[1;35m";
	final String ANSI_LIGHT_RED =  "\033[1;31m";
	final String ANSI_BROWN = "\033[0;33m";
	final String ANSI_GRAY =  "\033[0;37m";

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
