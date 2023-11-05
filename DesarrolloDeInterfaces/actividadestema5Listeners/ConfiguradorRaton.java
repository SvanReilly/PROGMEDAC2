package actividadestema5Listeners;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.event.ChangeEvent;
import javax.swing.JProgressBar;
import java.awt.Font;

public class ConfiguradorRaton extends JFrame {

	private static final long serialVersionUID = 4245468765612304746L;
	private JPanel contentPane;
	private JComboBox<Object> combo1;
	private JSpinner spinner1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfiguradorRaton frame = new ConfiguradorRaton();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConfiguradorRaton() {
		setTitle("Mouse Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Mouse Speed");
		label1.setBounds(63, 31, 78, 16);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Main mouse click");
		label2.setBounds(274, 31, 117, 16);
		contentPane.add(label2);
		
		combo1 = new JComboBox<Object>();
		combo1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				repaint();
			}
		});
		combo1.setModel(new DefaultComboBoxModel<Object>(new String[] {"Left", "Right"}));
		combo1.setBounds(249, 61, 142, 27);
		contentPane.add(combo1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setUI(new BasicProgressBarUI() {
		    protected Color getSelectionBackground() { return Color.black; }
		    protected Color getSelectionForeground() { return Color.black; }
		});

		// Establecer el color de la fuente del StringPainted a negro
		progressBar.setForeground(Color.black);
		progressBar.setToolTipText("hola");
		progressBar.setForeground(new Color(255, 255, 255));
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 15));
	
		progressBar.setBounds(22, 121, 162, 35);
		contentPane.add(progressBar);
		
		spinner1 = new JSpinner();
		spinner1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valorSeleccionado = (int) spinner1.getValue();
				if (valorSeleccionado == 0) {
					progressBar.setValue(0);
				} else if (valorSeleccionado == 25) {
					progressBar.setValue(25);
					progressBar.setForeground(Color.RED);
				} else if (valorSeleccionado == 50) {
					progressBar.setValue(50);
					progressBar.setForeground(Color.ORANGE);
				} else if (valorSeleccionado == 75) {
					progressBar.setValue(75);
					progressBar.setForeground(Color.YELLOW);
				} else if (valorSeleccionado == 100) {
					progressBar.setValue(100);
					progressBar.setForeground(Color.GREEN);
				}
			}
		});
		spinner1.setModel(new SpinnerNumberModel(0, 0, 100, 25));
		spinner1.setBounds(38, 61, 123, 26);
		contentPane.add(spinner1);
		
	}

	 
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawRect(274, 148 , 121, 61);
		if(combo1.getSelectedItem().toString().equals("Left")) {
			g.setColor(Color.GREEN);
			g.fillRect(275,149, 60, 60);
			g.setColor(Color.WHITE);
			g.fillOval(275,149,59,59);
		}
		else {
			g.setColor(Color.RED);
			g.fillRect(335,149, 60, 60);
			g.setColor(Color.WHITE);
			g.fillOval(335,149,60,60);
		}

	}
	
}