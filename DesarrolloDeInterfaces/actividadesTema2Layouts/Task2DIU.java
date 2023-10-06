package actividadesTema2Layouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Task2DIU extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * 
	 * 2. Diseñar una calculadora en el layout adecuado
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task2DIU frame = new Task2DIU();
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
	public Task2DIU() {
		setTitle("Calculadora de los Pitagóricos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JScrollPane panelPantalla = new JScrollPane();
		contentPane.add(panelPantalla);
		
		JTextArea TextoPantalla = new JTextArea();
		TextoPantalla.setText("2/0= Not determined");
		TextoPantalla.setFont(new Font("Arial", Font.PLAIN, 14));
		TextoPantalla.setEditable(false);
		TextoPantalla.setRows(12);
		panelPantalla.setViewportView(TextoPantalla);
		
		JSeparator separator_1 = new JSeparator();
		contentPane.add(separator_1);
		
		JPanel panelBotones2 = new JPanel();
		contentPane.add(panelBotones2);
		panelBotones2.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton buttonPlus = new JButton("+");
		buttonPlus.setBackground(Color.WHITE);
		buttonPlus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(buttonPlus);
		
		JButton buttonSubstraction = new JButton("-");
		buttonSubstraction.setBackground(Color.WHITE);
		buttonSubstraction.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(buttonSubstraction);
		
		JButton buttonDivision = new JButton("/");
		buttonDivision.setBackground(Color.WHITE);
		buttonDivision.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(buttonDivision);
		
		JButton buttonMultiply = new JButton("x");
		buttonMultiply.setBackground(Color.WHITE);
		buttonMultiply.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(buttonMultiply);
		
		JButton buttonPower = new JButton("");
		panelBotones2.add(buttonPower);
		buttonPower.setIcon(new ImageIcon("C:\\Users\\AlumnoT\\eclipse-workspace\\PROGMEDAC2\\DesarrolloDeInterfaces\\actividadesTema2Layouts\\xPowerByTwo.png"));
		buttonPower.setBackground(Color.WHITE);
		buttonPower.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		JSeparator separator_2 = new JSeparator();
		contentPane.add(separator_2);
		
		JPanel panelBotones1 = new JPanel();
		contentPane.add(panelBotones1);
		panelBotones1.setLayout(new GridLayout(4, 5, 0, 0));
		
		JButton button1 = new JButton("1");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelBotones1.add(button1);
		
		JButton button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button2);
		
		JButton button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button3.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button3);
		
		JButton button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button4.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button4);
		
		JButton button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button5.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button5);
		
		JButton button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button6.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button6);
		
		JButton button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button7.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button7);
		
		JButton button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button8.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button8);
		
		JButton button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button9.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button9);
		
		JButton button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton buttonClear = new JButton("");
		buttonClear.setIcon(new ImageIcon("C:\\Users\\AlumnoT\\eclipse-workspace\\PROGMEDAC2\\DesarrolloDeInterfaces\\actividadesTema2Layouts\\clearTrashCan.png"));
		buttonClear.setBackground(Color.WHITE);
		panelBotones1.add(buttonClear);
		buttonClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button0.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button0);
		
		JButton buttonEqual = new JButton("=");
		buttonEqual.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelBotones1.add(buttonEqual);
		
		JSeparator separator_3 = new JSeparator();
		contentPane.add(separator_3);
	}

}
