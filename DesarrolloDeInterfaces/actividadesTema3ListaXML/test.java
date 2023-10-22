package actividadesTema3ListaXML;

import java.awt.Color;
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

public class test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		

		
		try {
		    File xmlFile = new File(System.getProperty("user.dir") + "\\DesarrolloDeInterfaces\\actividadesTema3ListaXML\\tabla.xml");
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(xmlFile);
		    doc.getDocumentElement().normalize();

		    NodeList departamentoList = doc.getElementsByTagName("departamento");

		    for (int i = 0; i < departamentoList.getLength(); i++) {
		        Node departamentoNode = departamentoList.item(i);

		        if (departamentoNode.getNodeType() == Node.ELEMENT_NODE) {
		            Element departamentoElement = (Element) departamentoNode;

		            JPanel panelDepartamento = new JPanel();
		            contentPane.add(panelDepartamento);
		            panelDepartamento.setLayout(new GridLayout(0, 1, 0, 0));
		            String departamentoTipo = departamentoElement.getElementsByTagName("nombreDep").item(0).getTextContent();
		            JLabel departamentoLabel = new JLabel("Departamento de " + departamentoTipo);
		            departamentoLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		            if (departamentoTipo.equals("RECURSOS HUMANOS")) {
		            	departamentoLabel.setForeground(Color.ORANGE);
						
					} else if (departamentoTipo.equals("MARKETING Y PUBLICIDAD")) {
		            	departamentoLabel.setForeground(Color.MAGENTA);

					} else if (departamentoTipo.equals("DESARROLLO Y TECNOLOGIA")) {
		            	departamentoLabel.setForeground(Color.CYAN);

					} else if (departamentoTipo.equals("FINANZAS Y CONTABILIDAD")) {
		            	departamentoLabel.setForeground(Color.GREEN);

					}
		            panelDepartamento.add(departamentoLabel);

		            NodeList empleadoList = departamentoElement.getElementsByTagName("empleado");

		            for (int j = 0; j < empleadoList.getLength(); j++) {
		                Node empleadoNode = empleadoList.item(j);

		                if (empleadoNode.getNodeType() == Node.ELEMENT_NODE) {
		                    Element empleadoElement = (Element) empleadoNode;

		                    JPanel panelEmpleado = new JPanel();
		                    panelDepartamento.add(panelEmpleado);
		                    panelEmpleado.setLayout(new GridLayout(0, 1, 0, 0));

		                    JLabel nombreEmpleadoLabel = new JLabel(empleadoElement.getElementsByTagName("nombre").item(0).getTextContent());
		                    nombreEmpleadoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		                    
		                    JLabel dniEmpleadoLabel = new JLabel("DNI: " + empleadoElement.getElementsByTagName("dni").item(0).getTextContent());
		                    dniEmpleadoLabel.setFont(new Font("Courier New", Font.ITALIC, 11));
		                    
		                    JLabel telefonoEmpleadoLabel = new JLabel("Tel: " + empleadoElement.getElementsByTagName("telefono").item(0).getTextContent());
		                    telefonoEmpleadoLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		                    
		                    
		                    panelEmpleado.add(nombreEmpleadoLabel);
		                    panelEmpleado.add(dniEmpleadoLabel);
		                    panelEmpleado.add(telefonoEmpleadoLabel);
		                }
		            }
		        }
		    }

		    // ...

		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

}
