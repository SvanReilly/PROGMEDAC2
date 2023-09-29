package actividadesTema2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Task3Extra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField BaseNumber;
	private JTextField AlturaNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task3Extra frame = new Task3Extra();
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
	public Task3Extra() {
		setTitle("Calculadora de Áreas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel LabelL1 = new JLabel("Base");
		LabelL1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelL1.setBounds(106, 25, 95, 14);
		contentPane.add(LabelL1);
		BaseNumber = new JTextField();
		BaseNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BaseNumber.setBounds(66, 53, 122, 56);
		contentPane.add(BaseNumber);
		BaseNumber.setColumns(10);
		
		JLabel LabelL2 = new JLabel("Altura");
		LabelL2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelL2.setBounds(335, 25, 81, 14);
		contentPane.add(LabelL2);
		AlturaNumber = new JTextField();
		AlturaNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AlturaNumber.setBounds(300, 53, 122, 56);
		contentPane.add(AlturaNumber);
		AlturaNumber.setColumns(10);
		
		
		JTextArea registroResultado = new JTextArea();
		registroResultado.setFont(new Font("Arial", Font.PLAIN, 12));
		registroResultado.setBounds(38, 292, 424, 161);
		contentPane.add(registroResultado);
		
		
		JButton btnTriangulo = new JButton("");
		btnTriangulo.setIcon(new ImageIcon("C:\\Users\\AlumnoT\\Desktop\\Nueva carpeta\\piramide.png"));
		btnTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double areaT = (Double.parseDouble(BaseNumber.getText()) * Double.parseDouble(AlturaNumber.getText())) / 2;
				
				registroResultado.append("El área del triangulo de base " + BaseNumber.getText()+ " y altura " + AlturaNumber.getText() + " es " + areaT+ "\n");
				
			}
		});
		btnTriangulo.setBounds(94, 155, 95, 93);
		contentPane.add(btnTriangulo);
		
		JButton btnRectangulo = new JButton("");
		btnRectangulo.setIcon(new ImageIcon("C:\\Users\\AlumnoT\\Desktop\\Nueva carpeta\\rectangulo.png"));
		btnRectangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double base= Double.parseDouble(BaseNumber.getText());
				double altura= Double.parseDouble(AlturaNumber.getText());
				double areaR = Double.parseDouble(BaseNumber.getText()) * Double.parseDouble(AlturaNumber.getText());

				if(base !=altura) {
					registroResultado.append("El área del rectángulo de base " + BaseNumber.getText() + " y altura " + AlturaNumber.getText() + " es " + areaR+ "\n");
				} else {
					registroResultado.append("El área del cuadrado de lado " + BaseNumber.getText() +  " es " + areaR+ "\n");
				}
				
				
			}
		});
		btnRectangulo.setBounds(300, 155, 95, 93);
		contentPane.add(btnRectangulo);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroResultado.setText("");
			}
		});
		btnReset.setBounds(201, 459, 92, 23);
		contentPane.add(btnReset);
		
		
		
	}
}
