package actividadesTema3ListaXML;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelEmpleado frame = new PanelEmpleado();
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
	public PanelEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelEmpleado = new JPanel();
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel departamentoLabel = new JLabel("Departamento de ");
		departamentoLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		panelEmpleado.add(departamentoLabel);
		
		JLabel nombreEmpleadoLabel = new JLabel("Nombre: ");
		nombreEmpleadoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelEmpleado.add(nombreEmpleadoLabel);
		
		JLabel dniEmpleadoLabel = new JLabel("DNI: ");
		dniEmpleadoLabel.setFont(new Font("Courier New", Font.ITALIC, 11));
		panelEmpleado.add(dniEmpleadoLabel);
		
		JLabel telefonoEmpleadoLabel = new JLabel("Tel: ");
		telefonoEmpleadoLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		panelEmpleado.add(telefonoEmpleadoLabel);
		
		try {
        	File xmlFile = new File(System.getProperty("user.dir") + "\\DesarrolloDeInterfaces\\actividadesTema3\\Tabla.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList departamentoList = doc.getElementsByTagName("departamento");
		
            for (int i = 0; i < departamentoList.getLength(); i++) {
            	Node departamentoNode = departamentoList.item(i);
            	if (departamentoNode.getNodeType()==Node.ELEMENT_NODE) {
					Element departamentoElement = (Element) departamentoNode;
					departamentoLabel.setText(departamentoLabel.getText() + departamentoElement.getElementsByTagName("nombreDep").item(0).getTextContent());
					nombreEmpleadoLabel.setText(departamentoElement.getElementsByTagName("nombre").item(0).getTextContent());
					dniEmpleadoLabel.setText(departamentoElement.getElementsByTagName("dni").item(0).getTextContent());
					telefonoEmpleadoLabel.setText(departamentoElement.getElementsByTagName("telefono").item(0).getTextContent());
				
					panelEmpleado.add(departamentoLabel);
					panelEmpleado.add(nombreEmpleadoLabel);
					panelEmpleado.add(dniEmpleadoLabel);
					panelEmpleado.add(telefonoEmpleadoLabel);
					
					contentPane.add(panelEmpleado);
            	}
            	
            }
            
            
		 } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
