package fichero3readingXML;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;
import org.xml.sax.SAXException;

public class _1domXML {

	public static void main(String[] args)
            throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        
		try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("book.xml");

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

       // XPathExpression expression = xPath.compile("/library/book");

        //NodeList nodeList = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
    }

}
