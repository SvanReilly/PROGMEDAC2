package actividadesTema2Layouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Task3DIU extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * 
	 * 3. Elaborar una interfaz para una aplicacion de venta de entradas.
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task3DIU frame = new Task3DIU();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Color randomizarColor() {
		float random=(float) (Math.random()*2);
		Color colorRandom;
		if(random<=1) {
			colorRandom=Color.GREEN;
		}else if(random<=1.75) {
			colorRandom=Color.RED;
		}else {
			colorRandom=Color.BLACK;
		}
		return colorRandom;
		
	}
	
	public static String estadoReserva(JButton boton) {
		String estadoEntrada;
		if(boton.getBackground()==Color.RED) {
			estadoEntrada="LA ENTRADA " + boton.getText() + " ESTA AGOTADA.";
		}else if(boton.getBackground()==Color.GREEN){
			estadoEntrada="HAS RESERVADO LA ENTRADA " + boton.getText();
			boton.setBackground(Color.RED);
			boton.setForeground(Color.WHITE);
		}else {
			boton.setForeground(Color.WHITE);
			estadoEntrada="LA ENTRADA " + boton.getText() 
			+ " ESTA SIENDO RESERVADA EN ESTE MOMENTO POR OTRO USUARIO.";
		}
		return estadoEntrada;
	}
	
	/**
	 * Create the frame.
	 */
	public Task3DIU() {
		setTitle("Reservar entradas 'Toto World Tour'");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelOeste = new JPanel();
		panelOeste.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelOeste, BorderLayout.WEST);
		panelOeste.setLayout(new GridLayout(0, 3, 0, 0));
		
		Dialog3 dialog = new Dialog3();
		
		/*
		JButton Entrada1 = new JButton("1");
		Entrada1.setBackground(randomizarColor());
		if (Entrada1.getBackground()!=Color.GREEN) {
			Entrada1.setForeground(Color.WHITE);
		}
		Entrada1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				dialog.DialogText.setText(estadoReserva(Entrada1));
				//JOptionPane.showMessageDialog(null, estadoReserva(Entrada1));
			}
		});
		
		panelOeste.add(Entrada1);
		*/
		
		JButton Entrada1 = new JButton("WEST-VIP");
		Entrada1.setBackground(Color.GRAY);
		Entrada1.setForeground(Color.WHITE);
		
		Entrada1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
			}
		});
		panelOeste.add(Entrada1);
		
		JButton Entrada2 = new JButton("WEST-2");
		Entrada2.setBackground(randomizarColor());
		if (Entrada2.getBackground()!=Color.GREEN) {
			Entrada2.setForeground(Color.WHITE);
		}
		Entrada2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada2));
			}
		});
		panelOeste.add(Entrada2);
		
		JButton Entrada3 = new JButton("WEST-3");
		Entrada3.setBackground(randomizarColor());
		if (Entrada3.getBackground()!=Color.GREEN) {
			Entrada3.setForeground(Color.WHITE);
		}
		Entrada3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada3));
			}
		});
		panelOeste.add(Entrada3);
		
		JButton Entrada4 = new JButton("WEST-4");
		Entrada4.setBackground(randomizarColor());
		if (Entrada4.getBackground()!=Color.GREEN) {
			Entrada4.setForeground(Color.WHITE);
		}
		Entrada4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada4));
			}
		});
		panelOeste.add(Entrada4);
		
		JButton Entrada5 = new JButton("WEST-5");
		Entrada5.setBackground(randomizarColor());
		if (Entrada5.getBackground()!=Color.GREEN) {
			Entrada5.setForeground(Color.WHITE);
		}
		Entrada5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada5));
			}
		});
		panelOeste.add(Entrada5);
		
		JButton Entrada6 = new JButton("WEST-6");
		Entrada6.setBackground(randomizarColor());
		if (Entrada6.getBackground()!=Color.GREEN) {
			Entrada6.setForeground(Color.WHITE);
		}
		Entrada6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada6));
			}
		});
		panelOeste.add(Entrada6);
		
		JButton Entrada7 = new JButton("WEST-7");
		Entrada7.setBackground(randomizarColor());
		if (Entrada7.getBackground()!=Color.GREEN) {
			Entrada7.setForeground(Color.WHITE);
		}
		Entrada7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada7));
			}
		});
		panelOeste.add(Entrada7);
		
		JButton Entrada8 = new JButton("WEST-8");
		Entrada8.setBackground(randomizarColor());
		if (Entrada8.getBackground()!=Color.GREEN) {
			Entrada8.setForeground(Color.WHITE);
		}
		Entrada8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada8));
			}
		});
		panelOeste.add(Entrada8);
		
		JButton Entrada9 = new JButton("WEST-9");
		Entrada9.setBackground(randomizarColor());
		if (Entrada9.getBackground()!=Color.GREEN) {
			Entrada9.setForeground(Color.WHITE);
		}
		Entrada9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada9));
			}
		});
		panelOeste.add(Entrada9);
		
		JButton Entrada10 = new JButton("WEST-10");
		Entrada10.setBackground(randomizarColor());
		if (Entrada10.getBackground()!=Color.GREEN) {
			Entrada10.setForeground(Color.WHITE);
		}
		Entrada10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada10));
			}
		});
		panelOeste.add(Entrada10);
		
		JButton Entrada11 = new JButton("WEST-11");
		Entrada11.setBackground(randomizarColor());
		if (Entrada11.getBackground()!=Color.GREEN) {
			Entrada11.setForeground(Color.WHITE);
		}
		Entrada11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada11));
			}
		});
		panelOeste.add(Entrada11);
		
		JButton Entrada12 = new JButton("WEST-12");
		Entrada12.setBackground(randomizarColor());
		if (Entrada12.getBackground()!=Color.GREEN) {
			Entrada12.setForeground(Color.WHITE);
		}
		Entrada12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada12));
			}
		});
		panelOeste.add(Entrada12);
		
		JPanel panelEste = new JPanel();
		panelEste.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelEste, BorderLayout.EAST);
		panelEste.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton Entrada13 = new JButton("EAST-13");
		Entrada13.setBackground(randomizarColor());
		if (Entrada13.getBackground()!=Color.GREEN) {
			Entrada13.setForeground(Color.WHITE);
		}
		Entrada13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada13));
			}
		});
		panelEste.add(Entrada13);
		
		JButton Entrada14 = new JButton("EAST-14");
		Entrada14.setBackground(randomizarColor());
		if (Entrada14.getBackground()!=Color.GREEN) {
			Entrada14.setForeground(Color.WHITE);
		}
		Entrada14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada14));
			}
		});
		panelEste.add(Entrada14);
		
		JButton Entrada15 = new JButton("EAST-15");
		Entrada15.setBackground(randomizarColor());
		if (Entrada15.getBackground()!=Color.GREEN) {
			Entrada15.setForeground(Color.WHITE);
		}
		Entrada15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada15));
			}
		});
		panelEste.add(Entrada15);
		
		JButton Entrada16 = new JButton("EAST-16");
		Entrada16.setBackground(randomizarColor());
		if (Entrada16.getBackground()!=Color.GREEN) {
			Entrada16.setForeground(Color.WHITE);
		}
		Entrada16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada16));
			}
		});
		panelEste.add(Entrada16);
		
		JButton Entrada17 = new JButton("EAST-17");
		Entrada17.setBackground(randomizarColor());
		if (Entrada17.getBackground()!=Color.GREEN) {
			Entrada17.setForeground(Color.WHITE);
		}
		Entrada17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada17));
			}
		});
		panelEste.add(Entrada17);
		
		JButton Entrada18 = new JButton("EAST-18");
		Entrada18.setBackground(randomizarColor());
		if (Entrada18.getBackground()!=Color.GREEN) {
			Entrada18.setForeground(Color.WHITE);
		}
		Entrada18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada18));
			}
		});
		panelEste.add(Entrada18);
		
		JButton Entrada19 = new JButton("EAST-19");
		Entrada19.setBackground(randomizarColor());
		if (Entrada19.getBackground()!=Color.GREEN) {
			Entrada19.setForeground(Color.WHITE);
		}
		Entrada19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada19));
			}
		});
		panelEste.add(Entrada19);
		
		JButton Entrada20 = new JButton("EAST-20");
		Entrada20.setBackground(randomizarColor());
		if (Entrada20.getBackground()!=Color.GREEN) {
			Entrada20.setForeground(Color.WHITE);
		}
		Entrada20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada20));
			}
		});
		panelEste.add(Entrada20);
		
		JButton Entrada21 = new JButton("EAST-21");
		Entrada21.setBackground(randomizarColor());
		if (Entrada21.getBackground()!=Color.GREEN) {
			Entrada21.setForeground(Color.WHITE);
		}
		Entrada21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada21));
			}
		});
		panelEste.add(Entrada21);
		
		JButton Entrada22 = new JButton("EAST-22");
		Entrada22.setBackground(randomizarColor());
		if (Entrada22.getBackground()!=Color.GREEN) {
			Entrada22.setForeground(Color.WHITE);
		}
		Entrada22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada22));
			}
		});
		panelEste.add(Entrada22);
		
		JButton Entrada23 = new JButton("EAST-23");
		Entrada23.setBackground(randomizarColor());
		if (Entrada23.getBackground()!=Color.GREEN) {
			Entrada23.setForeground(Color.WHITE);
		}
		Entrada23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada23));
			}
		});
		panelEste.add(Entrada23);
		
		JButton Entrada24 = new JButton("EAST-24");
		Entrada24.setBackground(randomizarColor());
		if (Entrada24.getBackground()!=Color.GREEN) {
			Entrada24.setForeground(Color.WHITE);
		}
		Entrada24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada24));
			}
		});
		panelEste.add(Entrada24);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton Entrada25 = new JButton("NORTH-25");
		Entrada25.setBackground(randomizarColor());
		if (Entrada25.getBackground()!=Color.GREEN) {
			Entrada25.setForeground(Color.WHITE);
		}
		Entrada25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada25));
			}
		});
		panelNorte.add(Entrada25);
		
		JButton Entrada26 = new JButton("NORTH-26");
		Entrada26.setBackground(randomizarColor());
		if (Entrada26.getBackground()!=Color.GREEN) {
			Entrada26.setForeground(Color.WHITE);
		}
		Entrada26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada26));
			}
		});
		panelNorte.add(Entrada26);
		
		JButton Entrada27 = new JButton("NORTH-27");
		Entrada27.setBackground(randomizarColor());
		if (Entrada27.getBackground()!=Color.GREEN) {
			Entrada27.setForeground(Color.WHITE);
		}
		Entrada27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada27));
			}
		});
		panelNorte.add(Entrada27);
		
		JButton Entrada28 = new JButton("NORTH-28");
		Entrada28.setBackground(randomizarColor());
		if (Entrada28.getBackground()!=Color.GREEN) {
			Entrada28.setForeground(Color.WHITE);
		}
		Entrada28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada28));
			}
		});
		panelNorte.add(Entrada28);
		
		JButton Entrada29 = new JButton("NORTH-29");
		Entrada29.setBackground(randomizarColor());
		if (Entrada29.getBackground()!=Color.GREEN) {
			Entrada29.setForeground(Color.WHITE);
		}
		Entrada29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada29));
			}
		});
		panelNorte.add(Entrada29);
		
		JButton Entrada30 = new JButton("NORTH-30");
		Entrada30.setBackground(randomizarColor());
		if (Entrada30.getBackground()!=Color.GREEN) {
			Entrada30.setForeground(Color.WHITE);
		}
		Entrada30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada30));
			}
		});
		panelNorte.add(Entrada30);
		
		JPanel panelSur = new JPanel();
		panelSur.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton Entrada31 = new JButton("SOUTH-31");
		Entrada31.setBackground(randomizarColor());
		if (Entrada31.getBackground()!=Color.GREEN) {
			Entrada31.setForeground(Color.WHITE);
		}
		Entrada31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada31));
			}
		});
		panelSur.add(Entrada31);
		
		JButton Entrada32 = new JButton("SOUTH-32");
		Entrada32.setBackground(randomizarColor());
		if (Entrada32.getBackground()!=Color.GREEN) {
			Entrada32.setForeground(Color.WHITE);
		}
		Entrada32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada32));
			}
		});
		panelSur.add(Entrada32);
		
		JButton Entrada33 = new JButton("SOUTH-33");
		Entrada33.setBackground(randomizarColor());
		if (Entrada33.getBackground()!=Color.GREEN) {
			Entrada33.setForeground(Color.WHITE);
		}
		Entrada33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada33));
			}
		});
		panelSur.add(Entrada33);
		
		JButton Entrada34 = new JButton("SOUTH-34");
		Entrada34.setBackground(randomizarColor());
		if (Entrada34.getBackground()!=Color.GREEN) {
			Entrada34.setForeground(Color.WHITE);
		}
		Entrada34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada34));
			}
		});
		panelSur.add(Entrada34);
		
		JButton Entrada35 = new JButton("SOUTH-35");
		Entrada35.setBackground(randomizarColor());
		if (Entrada35.getBackground()!=Color.GREEN) {
			Entrada35.setForeground(Color.WHITE);
		}
		Entrada35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada35));
			}
		});
		panelSur.add(Entrada35);
		
		JButton Entrada36 = new JButton("SOUTH-36");
		Entrada36.setBackground(randomizarColor());
		if (Entrada36.getBackground()!=Color.GREEN) {
			Entrada36.setForeground(Color.WHITE);
		}
		Entrada36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, estadoReserva(Entrada36));
			}
		});
		panelSur.add(Entrada36);
		
		JLabel totoLogo = new JLabel("");
		totoLogo.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\DesarrolloDeInterfaces\\actividadesTema2Layouts\\toto.jpg"));
		totoLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(totoLogo, BorderLayout.CENTER);
	}

}
