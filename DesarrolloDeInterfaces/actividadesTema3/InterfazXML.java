package actividadesTema3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import javax.swing.*;
import java.awt.GridLayout;

public class InterfazXML extends JFrame {

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

    public InterfazXML() {
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

            NodeList departamentoList = doc.getElementsByTagName("departamento");

            for (int i = 0; i < departamentoList.getLength(); i++) {
                Node departamentoNode = departamentoList.item(i);
                if (departamentoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element departamentoElement = (Element) departamentoNode;
                    String departamentoNombre = departamentoElement.getElementsByTagName("nombre").item(0).getTextContent();

                    JPanel departamentoPanel = new JPanel();
                    departamentoPanel.setBorder(BorderFactory.createTitledBorder(departamentoNombre));
                    departamentoPanel.setLayout(new GridLayout(0, 1, 0, 0));

                    NodeList empleadoList = departamentoElement.getElementsByTagName("empleado");
                    for (int j = 0; j < empleadoList.getLength(); j++) {
                        Node empleadoNode = empleadoList.item(j);
                        if (empleadoNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element empleadoElement = (Element) empleadoNode;
                            String empleadoNombre = empleadoElement.getElementsByTagName("nombre").item(0).getTextContent();
                            String empleadoDni = empleadoElement.getElementsByTagName("dni").item(0).getTextContent();

                            JLabel empleadoLabel = new JLabel("Nombre: " + empleadoNombre + "DNI: " + empleadoDni);
                            departamentoPanel.add(empleadoLabel);
                        }
                    }
                    contentPane.add(departamentoPanel);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
