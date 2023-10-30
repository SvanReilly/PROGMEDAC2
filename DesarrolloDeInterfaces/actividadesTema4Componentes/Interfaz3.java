package actividadesTema4Componentes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Interfaz3 extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz3 frame = new Interfaz3();
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
	public Interfaz3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        CalendarioComponente calendario = new CalendarioComponente();
		
        setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		contentPane.add(calendario);
		
		JLabel lblNewLabel = new JLabel("CALENDARIO PITAG\u00D3RICO");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}

}
