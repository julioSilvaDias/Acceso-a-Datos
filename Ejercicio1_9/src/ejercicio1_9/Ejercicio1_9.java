package ejercicio1_9;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio1_9 {
	private static String RUTA = "cd.xml";

	public static void main(String[] args) {
		leerXml();
		crearCD();
		asignarNumeros();
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

	public static void asignarNumeros() {
		try {
			File file = new File(RUTA);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList listaCDs = doc.getElementsByTagName("CD");

			for (int i = 0; i < listaCDs.getLength(); i++) {
				Node cd = listaCDs.item(i);

				if (cd.getNodeType() == Node.ELEMENT_NODE) {
					Element elementoCD = (Element) cd;
					elementoCD.setAttribute("numero", String.valueOf(i + 1));
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

			System.out.println("Atributo 'numero' añadido a los CDs correctamente.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void crearCD() {

		try {
			Scanner teclado = new Scanner(System.in);
			String txt = "";
			File file = new File(RUTA);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			Node catalogo = doc.getFirstChild();

			Element nuevoCD = doc.createElement("CD");

			System.out.print("Introduce el titulo: ");
			txt = teclado.nextLine();
			Element titulo = doc.createElement("TITLE");
			titulo.appendChild(doc.createTextNode(txt));
			nuevoCD.appendChild(titulo);

			System.out.print("Introduce el artista: ");
			txt = teclado.nextLine();
			Element artista = doc.createElement("ARTIST");
			artista.appendChild(doc.createTextNode(txt));
			nuevoCD.appendChild(artista);

			System.out.print("Introduce el país: ");
			txt = teclado.nextLine();
			Element pais = doc.createElement("COUNTRY");
			pais.appendChild(doc.createTextNode(txt));
			nuevoCD.appendChild(pais);

			System.out.print("Introduce la compania: ");
			txt = teclado.nextLine();
			Element compania = doc.createElement("COMPANY");
			compania.appendChild(doc.createTextNode(txt));
			nuevoCD.appendChild(compania);

			System.out.print("Introduce el precio: ");
			txt = teclado.nextLine();
			Element precio = doc.createElement("PRICE");
			precio.appendChild(doc.createTextNode(txt));
			nuevoCD.appendChild(precio);

			System.out.print("Introduce el año: ");
			txt = teclado.nextLine();
			Element anio = doc.createElement("YEAR");
			anio.appendChild(doc.createTextNode(txt));
			nuevoCD.appendChild(anio);
			catalogo.appendChild(nuevoCD);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

			System.out.println("Nuevo CD añadido correctamente.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
