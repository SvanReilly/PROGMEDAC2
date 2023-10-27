package actividadesTema2Layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class Dialog3 extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog3 dialog = new Dialog3();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * 
	 */
	
	

	
	public Dialog3() {
		setTitle("Estado del palco VIP OESTE");
		setBounds(100, 100, 471, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 4, 0, 0));
		{
			JButton westVip1 = new JButton("1 WestViP");
			westVip1.setBackground(Task3DIU.randomizarColor());
			if (westVip1.getBackground()!=Color.GREEN) {
				westVip1.setForeground(Color.WHITE);
			}
			westVip1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, Task3DIU.estadoReserva(westVip1));
				}
			});
			contentPanel.add(westVip1);

		}
		{
			JButton westVip2 = new JButton("2 WestViP");
			westVip2.setBackground(Task3DIU.randomizarColor());
			if (westVip2.getBackground()!=Color.GREEN) {
				westVip2.setForeground(Color.WHITE);
			}
			westVip2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, Task3DIU.estadoReserva(westVip2));
				}
			});
			contentPanel.add(westVip2);
		}
		{
			JButton westVip3 = new JButton("3 WestViP");
			westVip3.setBackground(Task3DIU.randomizarColor());
			if (westVip3.getBackground()!=Color.GREEN) {
				westVip3.setForeground(Color.WHITE);
			}
			westVip3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, Task3DIU.estadoReserva(westVip3));
				}
			});
			contentPanel.add(westVip3);
		}
		{
			JButton westVip4 = new JButton("4 WestViP");
			westVip4.setBackground(Task3DIU.randomizarColor());
			if (westVip4.getBackground()!=Color.GREEN) {
				westVip4.setForeground(Color.WHITE);
			}
			westVip4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, Task3DIU.estadoReserva(westVip4));
				}
			});
			contentPanel.add(westVip4);
		}
		{
			JButton westVip5 = new JButton("5 WestViP");
			westVip5.setBackground(Task3DIU.randomizarColor());
			if (westVip5.getBackground()!=Color.GREEN) {
				westVip5.setForeground(Color.WHITE);
			}
			westVip5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, Task3DIU.estadoReserva(westVip5));
				}
			});
			contentPanel.add(westVip5);
		}
		{
			JButton westVip6 = new JButton("6 WestViP");
			westVip6.setBackground(Task3DIU.randomizarColor());
			if (westVip6.getBackground()!=Color.GREEN) {
				westVip6.setForeground(Color.WHITE);
			}
			westVip6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, Task3DIU.estadoReserva(westVip6));
				}
			});
			contentPanel.add(westVip6);
		}
		{
			JButton westVip7 = new JButton("7 WestViP");
			westVip7.setBackground(Task3DIU.randomizarColor());
			if (westVip7.getBackground()!=Color.GREEN) {
				westVip7.setForeground(Color.WHITE);
			}
			westVip7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, Task3DIU.estadoReserva(westVip7));
				}
			});
			contentPanel.add(westVip7);
		}
		{
			JButton westVip8 = new JButton("8 WestViP");
			westVip8.setBackground(Task3DIU.randomizarColor());
			if (westVip8.getBackground()!=Color.GREEN) {
				westVip8.setForeground(Color.WHITE);
			}
			westVip8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, Task3DIU.estadoReserva(westVip8));
				}
			});
			contentPanel.add(westVip8);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
	
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				dispose();
			}
		}
	}

}
