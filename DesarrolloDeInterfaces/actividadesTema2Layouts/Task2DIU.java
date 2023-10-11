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
	 * 2. Dise�ar una calculadora en el layout adecuado
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
		setTitle("Calculadora de los Pitagoricos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JScrollPane panelPantalla = new JScrollPane();
		contentPane.add(panelPantalla);

		JTextArea TextoPantalla = new JTextArea();
		TextoPantalla.setLineWrap(true);
		TextoPantalla.setText("");
		TextoPantalla.setFont(new Font("Arial", Font.PLAIN, 20));
		TextoPantalla.setEditable(false);
		TextoPantalla.setRows(12);
		panelPantalla.setViewportView(TextoPantalla);

		JSeparator separator_1 = new JSeparator();
		contentPane.add(separator_1);

		JPanel panelBotones2 = new JPanel();
		contentPane.add(panelBotones2);
		panelBotones2.setLayout(new GridLayout(0, 7, 0, 0));

		// Tecla Sumar
		JButton buttonPlus = new JButton("+");
		buttonPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append(" + ");
			}
		});
		buttonPlus.setBackground(new Color(151, 255, 153));
		buttonPlus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(buttonPlus);

		// Tecla Restar
		JButton buttonSubstraction = new JButton("-");
		buttonSubstraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append(" - ");
			}
		});
		buttonSubstraction.setBackground(new Color(255, 128, 128));
		buttonSubstraction.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(buttonSubstraction);

		// Tecla Dividir
		JButton buttonDivision = new JButton("/");
		buttonDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append(" / ");
			}
		});
		buttonDivision.setBackground(new Color(254, 179, 133));
		buttonDivision.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(buttonDivision);

		// Tecla Multiplicar
		JButton buttonMultiply = new JButton("x");
		buttonMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append(" x ");
			}
		});
		buttonMultiply.setBackground(new Color(196, 162, 253));
		buttonMultiply.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(buttonMultiply);

		// Tecla Elevar al cuadrado
		JButton buttonPower = new JButton("");
		buttonPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {
				String cadenaNumero1 = TextoPantalla.getText();
				double numero1;
				if (cadenaNumero1.equals("")) {
					numero1 = Math.pow(Double.parseDouble("1"), 2);
				} else {
					numero1 = Math.pow(Double.parseDouble(cadenaNumero1), 2);
					TextoPantalla.setText(cadenaNumero1 + " = " + numero1 + "\n");
				}
			
        } catch (NumberFormatException ex) {
            TextoPantalla.setText("Por favor, introduzca un orden valido de los elementos." + "\n");
        }
		
			}
		});
		
		// Tecla Raiz cuadrada
		JButton squareRootButton = new JButton("\u221A");
		squareRootButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		try {
				String cadenaNumero1 = TextoPantalla.getText();
				String impresionPant;
				double numero1;
				if (cadenaNumero1.equals("")) {
					numero1 = Math.sqrt(Double.parseDouble("1"));
					impresionPant=("\u221A"+cadenaNumero1 + " = " + numero1 + "\n");
				} else if (cadenaNumero1.contains("- ")) {
					impresionPant=("No es posible realizar esta operacion sin el uso de numeros imaginarios.");
				} else {
					numero1 = Math.sqrt(Double.parseDouble(cadenaNumero1));
					impresionPant=("\u221A"+cadenaNumero1 + " = " + numero1 + "\n");
				}
				TextoPantalla.setText(impresionPant);
        } catch (NumberFormatException ex) {
            TextoPantalla.setText("Por favor, introduzca un orden valido de los elementos." + "\n");
        }
		
			}
		});
		squareRootButton.setBackground(new Color(228, 226, 154));
		squareRootButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(squareRootButton);
		panelBotones2.add(buttonPower);
		buttonPower.setIcon(new ImageIcon(
				System.getProperty("user.dir") + "\\DesarrolloDeInterfaces\\actividadesTema2Layouts\\xPowerByTwo.png"));
		buttonPower.setBackground(Color.WHITE);
		buttonPower.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		JButton dotButton = new JButton(".");
		dotButton.setBackground(new Color(166, 166, 166));
		dotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append(".");
			}
		});
		dotButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panelBotones2.add(dotButton);

		JSeparator separator_2 = new JSeparator();
		contentPane.add(separator_2);

		JPanel panelBotones1 = new JPanel();
		contentPane.add(panelBotones1);
		panelBotones1.setLayout(new GridLayout(4, 5, 0, 0));

		// Tecla 1
		JButton button1 = new JButton("1");
		button1.setBackground(new Color(170, 217, 255));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("1");
			}
		});
		button1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelBotones1.add(button1);

		// Tecla 2
		JButton button2 = new JButton("2");
		button2.setBackground(new Color(170, 217, 255));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("2");
			}
		});
		button2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button2);

		// Tecla 3
		JButton button3 = new JButton("3");
		button3.setBackground(new Color(170, 217, 255));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("3");
			}
		});
		button3.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button3);

		// Tecla 4
		JButton button4 = new JButton("4");
		button4.setBackground(new Color(170, 217, 255));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("4");
			}
		});
		button4.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button4);

		// Tecla 5
		JButton button5 = new JButton("5");
		button5.setBackground(new Color(170, 217, 255));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("5");
			}
		});
		button5.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button5);

		// Tecla 6
		JButton button6 = new JButton("6");
		button6.setBackground(new Color(170, 217, 255));
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("6");
			}
		});
		button6.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button6);

		// Tecla 7
		JButton button7 = new JButton("7");
		button7.setBackground(new Color(170, 217, 255));
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("7");
			}
		});
		button7.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button7);

		// Tecla 8
		JButton button8 = new JButton("8");
		button8.setBackground(new Color(170, 217, 255));
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("8");
			}
		});
		button8.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button8);

		// Tecla 9
		JButton button9 = new JButton("9");
		button9.setBackground(new Color(170, 217, 255));
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("9");
			}
		});
		button9.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button9);

		// Tecla 0
		JButton button0 = new JButton("0");
		button0.setBackground(new Color(170, 217, 255));
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.append("0");
			}
		});

		// Tecla BORRAR
		JButton buttonClear = new JButton("");
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoPantalla.setText("");
			}
		});
		buttonClear.setIcon(new ImageIcon(
				System.getProperty("user.dir") + "\\DesarrolloDeInterfaces\\actividadesTema2Layouts\\clearTrashCan.png"));
		buttonClear.setBackground(new Color(255, 255, 255));
		panelBotones1.add(buttonClear);
		buttonClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button0.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelBotones1.add(button0);

		JButton buttonEqual = new JButton("=");
		buttonEqual.setBackground(new Color(255, 255, 255));
		buttonEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        TextoPantalla.append(" = ");

		        String textoPantalla = TextoPantalla.getText();
		        String[] partes = textoPantalla.split(" ");
		        String impresionPant="";
		            try {
		                double numero1 = Double.parseDouble(partes[0].trim());
		                String simbolo = partes[1].trim();
		                double numero2 = Double.parseDouble(partes[2].trim());
		                double resultado = 0;
		                switch (simbolo) {
		                    case "+":
		                        resultado = numero1 + numero2;
		    					impresionPant=(numero1 + " " + simbolo + " " + numero2 + " = " + resultado + "\n");
		                        break;
		                    case "-":
		                        resultado = numero1 - numero2;
		                        impresionPant=(numero1 + " " + simbolo + " " + numero2 + " = " + resultado + "\n");
		                        break;
		                    case "x":
		                        resultado = numero1 * numero2;
		                        impresionPant=(numero1 + " " + simbolo + " " + numero2 + " = " + resultado + "\n");
		                        break;
		                    case "/":
		                        if (numero2 !=0) {
		                            resultado = numero1 / numero2;
		                            impresionPant=(numero1 + " " + simbolo + " " + numero2 + " = " + resultado + "\n");
		                        } else {
		                        	impresionPant=(numero1 + " " + simbolo + " " + numero2 + " = " 
		                        + "El resultado de esta operacion es una indeterminacion." + "\n");
		                        }
		                        break;
		                    default:
		                    	impresionPant=("Operador no v�lido." + "\n");
		                        break;
		                }

		                TextoPantalla.setText(impresionPant);
		            } catch (NumberFormatException ex) {
		                TextoPantalla.setText("Por favor, introduzca un orden valido de los elementos." + "\n");
		            }
		    }
		});

		buttonEqual.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelBotones1.add(buttonEqual);

		JSeparator separator_3 = new JSeparator();
		contentPane.add(separator_3);
	}

}
