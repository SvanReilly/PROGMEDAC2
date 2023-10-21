package actividadesTema3ListaXML;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import javax.swing.*;
import java.awt.GridLayout;

public class test extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	InterfazXML frame = new InterfazXML();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public test() {
    	setTitle("Lista de empleados XML");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        try {
            File xmlFile = new File(System.getProperty("user.dir") + "\\DesarrolloDeInterfaces\\actividadesTema3\\Tabla.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList departamentos = doc.getElementsByTagName("departamento");

            for (int i = 0; i < departamentos.getLength(); i++) {
                Element departamento = (Element) departamentos.item(i);
                String nombreDepart = departamento.getElementsByTagName("nombreDepart").item(0).getTextContent();

                NodeList empleados = departamento.getElementsByTagName("empleado");
                for (int j = 0; j < empleados.getLength(); j++) {
                    Element empleado = (Element) empleados.item(j);

                    String nombre = empleado.getElementsByTagName("nombre").item(0).getTextContent();
                    String dni = empleado.getElementsByTagName("dni").item(0).getTextContent();
                    String telefono = empleado.getElementsByTagName("telefono").item(0).getTextContent();

                    JPanel empleadoPanel = new JPanel();
                    empleadoPanel.setBorder(BorderFactory.createTitledBorder(nombreDepart));

                    JLabel departLabel = new JLabel("Nombre: " + nombreDepart);
                    JLabel nombreLabel = new JLabel("Nombre: " + nombre);
                    JLabel dniLabel = new JLabel("DNI: " + dni);
                    JLabel telefonoLabel = new JLabel("Teléfono: " + telefono);

                    empleadoPanel.add(departLabel);
                    empleadoPanel.add(nombreLabel);
                    empleadoPanel.add(dniLabel);
                    empleadoPanel.add(telefonoLabel);

                    contentPane.add(empleadoPanel);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
