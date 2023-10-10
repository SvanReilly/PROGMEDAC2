package interfaz1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;


public class JFrame1 extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame1 frame = new JFrame1();
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
	public JFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 567);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JButton btnNewButton = new JButton("Useless button");
		panel_5.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		panel_5.add(separator);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Check if you dumb");
		panel_5.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Check if you asshole");
		chckbxNewCheckBox_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_5.add(chckbxNewCheckBox_1);
		
		JTextArea txtrTellMeAbout = new JTextArea();
		panel_5.add(txtrTellMeAbout);
		txtrTellMeAbout.setText("Write down here");
		
		JTextPane txtpnYouDefinitelyDumbass = new JTextPane();
		txtpnYouDefinitelyDumbass.setText("you definitely dumbass at:");
		panel_5.add(txtpnYouDefinitelyDumbass);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(94);
		progressBar.setStringPainted(true);
		panel_5.add(progressBar);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
	}

}
