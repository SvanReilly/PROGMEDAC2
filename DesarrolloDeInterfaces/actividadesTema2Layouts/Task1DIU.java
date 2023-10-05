package actividadesTema2Layouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Task1DIU extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField userName;

	/*
	 * 
	 * 1. Realizar un formulario con una ventana Dialog El JFrame principal estará
	 * formado por: • Dos JLabel ‘Usuario’ y ‘Contraseña’. • Un JTexField para
	 * introducir el nombre. • Un JPassWordField para introducir la contraseña. •
	 * Dos JButton ‘Inicio’ y ‘Salir’. El botón ‘Inicio’ tendrá implementada la
	 * función del evento escuchador, para que, al hacer clic, se compruebe si los
	 * datos son correctos y así abrir la ventana de ‘Bienvenida’.
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task1DIU frame = new Task1DIU();
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
	public Task1DIU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel LabelUsuario = new JLabel("User");
		panel.add(LabelUsuario);
		
		userName = new JTextField();
		panel.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		panel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		String contra = "1234";
		String userAdmin = "admin";
		JButton Log_In_Button = new JButton("Log In");
		Log_In_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwordEntered = String.copyValueOf(passwordField.getPassword());
				if (passwordEntered.equals(contra) && userName.getText().equals(userAdmin) ) {
					
					Dialog1 dialog = new Dialog1();
				
					
				} else {

				}
				
			}
		});
		panel.add(Log_In_Button);
		

		
		
		JButton Exit_Button = new JButton("Exit");
		Exit_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(Exit_Button);
		dispose();
	}

}
