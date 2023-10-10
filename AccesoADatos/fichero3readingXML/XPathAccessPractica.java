package fichero3readingXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XPathAccessPractica {

	public static void main(String[] args) throws XPathExpressionException, SAXException, IOException {
		// TODO Auto-generated method stub

		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BLACK = "\u001B[30m";
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_YELLOW = "\u001B[33m";
		final String ANSI_LIGHT_PURPLE  = "\033[1;35m";
		final String ANSI_LIGHT_YELLOW = "\u001B[93m";
		final String ANSI_BOLD = "\u001B[1m";
		final String ANSI_UNDERLINE = "\u001B[4m";
		final String ANSI_STOP_UNDERLINE = "\u001B[24m";
		final String ANSI_LIGHT_RED =  "\033[1;31m";
		final String ANSI_LIGHT_CYAN = "\033[1;36m";
		final String ANSI_LIGHT_GREEN = "\033[1;32m";
		final String ANSI_GRAY = "\033[0;37m";

		try {
			// System.getProperty("user.dir") + "Directorio restante desde la carpeta del proyecto hasta su ubicacion
			// "Solucion a todos los problemas de directorio existencial.
			File archivoXML = new File(System.getProperty("user.dir") + "\\AccesoADatos\\fichero3readingXML\\book.xml"); 
			DocumentBuilderFactory docBldrFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBldrFactory.newDocumentBuilder();
			Document archivoFinal = docBuilder.parse(archivoXML);
			
			archivoFinal.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "/library/book";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(archivoFinal, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				System.out.println(ANSI_UNDERLINE + "\nNombre del nodo" + ANSI_STOP_UNDERLINE + ": " + ANSI_GRAY
						+ nNode.getNodeName() + ANSI_RESET);
				

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					if (eElement.getElementsByTagName("title").item(0).getTextContent().contains("Book Title") ) {
						eElement.getElementsByTagName("title").item(0).setTextContent(ANSI_GRAY + "Sin registro." + ANSI_RESET);
						eElement.getElementsByTagName("author").item(0).setTextContent(ANSI_GRAY + "Sin registro." + ANSI_RESET);
						eElement.getElementsByTagName("year").item(0).setTextContent(ANSI_GRAY + "Sin registro." + ANSI_RESET);
						eElement.getElementsByTagName("genre").item(0).setTextContent(ANSI_GRAY + "Sin registro." + ANSI_RESET);


					}
					
				
					System.out.println(ANSI_GRAY + "Obra " + ANSI_RESET + (i + 1));
					System.out.println(ANSI_GREEN + "Título : " + ANSI_BOLD + ANSI_LIGHT_GREEN
							+ eElement.getElementsByTagName("title").item(0).getTextContent() + ANSI_RESET);
					System.out.println(ANSI_CYAN + "Autor : " + ANSI_BOLD + ANSI_LIGHT_CYAN
							+ eElement.getElementsByTagName("author").item(0).getTextContent() + ANSI_RESET);
					System.out.println(ANSI_RED + "Año : " + ANSI_BOLD + ANSI_LIGHT_RED
							+ eElement.getElementsByTagName("year").item(0).getTextContent() + ANSI_RESET);
					System.out.println(ANSI_LIGHT_YELLOW + "Género : " + ANSI_BOLD + ANSI_YELLOW
							+ eElement.getElementsByTagName("genre").item(0).getTextContent() + ANSI_RESET);
					System.out.println(ANSI_BLACK + "_______________________________" + ANSI_RESET);
					
					
					
				}
				
				File modifiedXML = new File(System.getProperty("user.dir") + "\\AccesoADatos\\fichero3readingXML\\book2.xml");
				FileWriter escibirEnXML = new FileWriter(modifiedXML);
			}
		} catch (ParserConfigurationException e) {
			// TODO: handle exception
		}
	}
}
