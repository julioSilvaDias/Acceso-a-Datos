package ejercicio1_9;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio1_9 {
	private static String RUTA = "cd.xml";

	public static void main(String[] args) {
		leerXml();
	}

	public static void leerXml() {
		try {
			File file = new File(RUTA);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("CD");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.print(nNode.getNodeName());
			

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					NodeList tList = eElement.getElementsByTagName("TITLE");
					NodeList aList = eElement.getElementsByTagName("ARTIST");
					NodeList cList = eElement.getElementsByTagName("COUNTRY");
					NodeList coList = eElement.getElementsByTagName("COMPANY");
					NodeList pList = eElement.getElementsByTagName("PRICE");
					NodeList yList = eElement.getElementsByTagName("YEAR");

					for (int j = 0; j < tList.getLength(); j++) {
						Node node1 = tList.item(j);
						Node node2 = aList.item(j);
						Node node3 = cList.item(j);
						Node node4 = coList.item(j);
						Node node5 = pList.item(j);
						Node node6 = yList.item(j);
						if (node1.getNodeType() == node1.ELEMENT_NODE) {
							Element cd = (Element) node1;
							Element cd2 = (Element) node2;
							Element cd3 = (Element) node3;
							Element cd4 = (Element) node4;
							Element cd5 = (Element) node5;
							Element cd6 = (Element) node6;

							System.out.println();
							System.out.print("	Titulo: ");
							System.out.println(cd.getTextContent());
							System.out.print("	Artista: ");
							System.out.println(cd2.getTextContent());
							System.out.print("	País: ");
							System.out.println(cd3.getTextContent());
							System.out.print("	Compania: ");
							System.out.println(cd4.getTextContent());
							System.out.print("	Precio: ");
							System.out.println(cd5.getTextContent());
							System.out.print("	año: ");
							System.out.println(cd6.getTextContent());
							System.out.println();
						}
					}
				}

			}
		} catch (Exception e) {

		}
	}

	public static void creaCD() {
		
		try {
			File file = new File(RUTA);
			DocumentBuilderFactory dbFactory = 	DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			Node catalogo = doc.getFirstChild();
			
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
