package ejemplos;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class Ejemplo1 {

	public static void main(String[] args) {
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			Element elementoRaiz = doc.createElement("coches");
			doc.appendChild(elementoRaiz);

			Element cochesU = doc.createElement("cochesUtilitarios");
			elementoRaiz.appendChild(cochesU);

			Attr attr = doc.createAttribute("compania");
			attr.setValue("Hyundai");
			cochesU.setAttributeNode(attr);

			Element nCoche = doc.createElement("nombreCoche");
			Attr attrType = doc.createAttribute("tipo");
			attrType.setValue("4X4");
			nCoche.setAttributeNode(attrType);
			nCoche.appendChild(doc.createTextNode("Tucson"));
			cochesU.appendChild(nCoche);

			Element nCoche1 = doc.createElement("nombreCoche");

			Attr attrType1 = doc.createAttribute("tipo");

			attrType1.setValue("normal");

			nCoche1.setAttributeNode(attrType1);

			nCoche1.appendChild(doc.createTextNode("Coupe"));

			cochesU.appendChild(nCoche1);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();

			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File("coches.xml"));

			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);

		} catch (Exception e) {
		}
	}

}
