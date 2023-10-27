package actividadesTema3ListaXML;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class test extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

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

    public test() {
        setTitle("Lista de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 455, 912);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(contentPane);

        setContentPane(scrollPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        try {
            File xmlFile = new File(System.getProperty("user.dir") +
            		"\\DesarrolloDeInterfaces\\actividadesTema3ListaXML\\tabla.xml");
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
                    panelDepartamento.setBorder(new EmptyBorder(10, 0, 0, 0));

                    String departamentoTipo = departamentoElement.
                    		getElementsByTagName("nombreDep").item(0).getTextContent();
                    JLabel departamentoLabel = new JLabel(departamentoTipo);
                    departamentoLabel.setAlignmentY(CENTER_ALIGNMENT);
                    departamentoLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
                    if (departamentoTipo.equals("RECURSOS HUMANOS")) {
                        departamentoLabel.setForeground(Color.CYAN);

                    } else if (departamentoTipo.equals("MARKETING Y PUBLICIDAD")) {
                        departamentoLabel.setForeground(Color.MAGENTA);

                    } else if (departamentoTipo.equals("DESARROLLO Y TECNOLOGIA")) {
                        departamentoLabel.setForeground(Color.RED);

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
                            panelEmpleado.setPreferredSize(new Dimension(75,75));
                            panelEmpleado.setLayout(new GridLayout(0, 2, 0, 0));
                            panelEmpleado.setBorder(new EmptyBorder(10, 5, 2, 0));

                            JLabel nombreEmpleadoLabel = new JLabel(empleadoElement.
                            		getElementsByTagName("nombre").item(0).getTextContent());
                            nombreEmpleadoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

                            JLabel dniEmpleadoLabel = new JLabel("DNI: " + empleadoElement.
                            		getElementsByTagName("dni").item(0).getTextContent());
                            dniEmpleadoLabel.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 14));

                            JLabel telefonoEmpleadoLabel = new JLabel("Tel: " + empleadoElement.
                            		getElementsByTagName("telefono").item(0).getTextContent());
                            telefonoEmpleadoLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
                            
                            JLabel correoEmpleadoLabel = new JLabel("Email: " + empleadoElement.
                            		getElementsByTagName("correo").item(0).getTextContent());
                            correoEmpleadoLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
                            
                            JLabel dirEmpleadoLabel = new JLabel("Domicilio: " + empleadoElement.
                            		getElementsByTagName("direccion").item(0).getTextContent());
                            dirEmpleadoLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
                            
                            JLabel cargoEmpleadoLabel = new JLabel("Cargo: " + empleadoElement.
                            		getElementsByTagName("cargo").item(0).getTextContent());
                            cargoEmpleadoLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
                            
                            JLabel salarioEmpleadoLabel = new JLabel("Salario: " + empleadoElement.
                            		getElementsByTagName("salario").item(0).getTextContent());
                            salarioEmpleadoLabel.setFont(new Font("Consolas", Font.PLAIN, 14));

                            panelEmpleado.add(nombreEmpleadoLabel);

                            // Agregar botón para mostrar más información sobre el empleado
                            JButton infoButton = new JButton("Más información");
                            infoButton.setBackground(Color.WHITE);
                            infoButton.setForeground(Color.BLACK);
                            infoButton.setBounds(300, 152, 103, 45);
                            infoButton.setPreferredSize(new Dimension(103,45));
                            panelEmpleado.add(infoButton);

                            // ActionListener para el botón de información
                            infoButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    JDialog dialog = new JDialog();
                                    dialog.setBounds(100, 100, 471, 312);
                                    dialog.setPreferredSize(new Dimension(400, 300));
                                    String nombre_empleado = nombreEmpleadoLabel.getText();
                                    dialog.setTitle(departamentoTipo + " - " + nombre_empleado);
                                    JPanel panelMasInformacion = new JPanel();
                                    panelMasInformacion.setLayout(new GridLayout(0, 1, 0, 0));
                                    panelMasInformacion.setBorder(new EmptyBorder(10, 5, 2, 0));

                                    panelMasInformacion.add(dniEmpleadoLabel);
                                    panelMasInformacion.add(telefonoEmpleadoLabel);
                                    panelMasInformacion.add(correoEmpleadoLabel);
                                    panelMasInformacion.add(dirEmpleadoLabel);
                                    panelMasInformacion.add(cargoEmpleadoLabel);
                                    panelMasInformacion.add(salarioEmpleadoLabel);

                                    dialog.add(panelMasInformacion);
                                    dialog.pack();
                                    dialog.setVisible(true);
                                }
                            });
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}