package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.jdom.input.DOMBuilder;

/**
 * Build document from a dom
 * 
 * @author no_name
 *
 */
public class BuildDocumentFromADom {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			
			DocumentBuilder domBuilder = factory.newDocumentBuilder();
			Document w3cDocument = domBuilder.parse("test.xml");
			
			DOMBuilder jdomBuilder = new DOMBuilder();
			org.jdom.Document jdomDocument = jdomBuilder.build(w3cDocument);
			System.out.println(jdomDocument);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
