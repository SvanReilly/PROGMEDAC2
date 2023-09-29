package actividadesTema2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;

public class Task1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task1 frame = new Task1();
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
	public Task1() {
		setTitle("Registrar evento boton pulsado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton BotonMostrar = new JButton("Mostrar");
		BotonMostrar.setBounds(168, 94, 116, 47);
		panel.add(BotonMostrar);

		
		JTextArea txtrBotnPulsado = new JTextArea();
		txtrBotnPulsado.setFont(new Font("SansSerif", Font.BOLD, 11));
		txtrBotnPulsado.setBounds(10, 11, 133, 259);
		panel.add(txtrBotnPulsado);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrBotnPulsado.setText("");
			}
		});
		btnReset.setBounds(193, 173, 63, 29);
		panel.add(btnReset);
		
		BotonMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	txtrBotnPulsado.append("Boton Pulsado\n");
            	//txtrBotnPulsado.setText("Boton Pulsado \n" + txtrBotnPulsado.getText()); //less efficient
            }
});
		
		
	}
}
