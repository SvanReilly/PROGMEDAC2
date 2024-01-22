package actividadesTema2Layouts;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;

public class recordatorioDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel recordatorioPanel = new JPanel();
	private JComboBox<String> horasBox;
	String horaSeleccionada = "";
	CalendarioComponente calendario = new CalendarioComponente();
	String day, month, year;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			recordatorioDialog dialog = new recordatorioDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public recordatorioDialog() {
		
	}
	
	public recordatorioDialog(String day, String month, String year) {
		
		String[] opcionesHoras= {"00:00", "01:00", "02:00","03:00", "04:00", 
				"05:00", "06:00","07:00","08:00", "09:00", "10:00","11:00",
				"12:00", "13:00", "14:00","15:00","16:00", "17:00", "18:00",
				"19:00","20:00", "21:00", "22:00","23:00"};
		setBounds(100, 100, 550, 383);
		getContentPane().setLayout(new BorderLayout());
		recordatorioPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(recordatorioPanel, BorderLayout.CENTER);
		recordatorioPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			JPanel panelHoras = new JPanel();
			recordatorioPanel.add(panelHoras);
			panelHoras.setLayout(new BorderLayout(0, 0));
			{
				
				horasBox = new JComboBox<>(opcionesHoras);
				panelHoras.add(horasBox, BorderLayout.NORTH);
				
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				panelHoras.add(scrollPane, BorderLayout.CENTER);
				{
					JTextArea textArea = new JTextArea();
					scrollPane.setViewportView(textArea);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				buttonPane.setLayout(new GridLayout(0, 1, 5, 0));
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(255, 147, 147));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				JButton okButton = new JButton("Guardar recordatorio");
				okButton.setBackground(new Color(129, 214, 254));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						horaSeleccionada=(String) horasBox.getSelectedItem();
	                    JOptionPane.showMessageDialog(null, "Se guardó el recordatorio para las " + horaSeleccionada + " del día " + day + " de " + month + " del " + year);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
