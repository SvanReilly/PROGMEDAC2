package actividadesTema2Layouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import actividadesTema4Componentes.CalendarioComponente;

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
		setBounds(100, 100, 558, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel LabelUsuario = new JLabel("User");
		LabelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		LabelUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(LabelUsuario);
		
		userName = new JTextField();
		panel.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		String contra = "1234";
		String userAdmin = "admin";
		JButton Log_In_Button = new JButton("Log In");
		Dialog1 dialog = new Dialog1();
		Log_In_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwordEntered = String.copyValueOf(passwordField.getPassword());
				
				if (passwordEntered.equals(contra) && userName.getText().equals(userAdmin) ) {
					
					dialog.setVisible(true);
					dialog.DialogText.setText("BIENVENIDO.");
				
					
				} else {
					//JOptionPane.showInternalMessageDialog(null, "El usuario o la contraseña son incorrectas, intente de nuevo.");
					dialog.setVisible(true);
					dialog.DialogText.setText("El usuario o la contraseña son incorrectas, intente de nuevo.");
				}
				
			}
		});
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1);
		panel.add(Log_In_Button);
		

		
		
		JButton Exit_Button = new JButton("Exit");
		Exit_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			
			}
		});
		panel.add(Exit_Button);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(20);
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(20);
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setHgap(20);
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setVgap(20);
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Birthdate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog calendarioRumano = new JDialog();
				CalendarioComponente calendarioComponente = new CalendarioComponente();
				calendarioRumano.setVisible(true);
				calendarioRumano.setBounds(100, 100, 650, 465);
				calendarioRumano.getContentPane().add(calendarioComponente);
				
			}
		});
		panel_4.add(btnNewButton);
		

	}

}
