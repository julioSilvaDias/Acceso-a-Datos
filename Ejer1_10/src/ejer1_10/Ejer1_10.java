package ejer1_10;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class Ejer1_10 {

	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuilder;
		try {
			dbBuilder = dbFactory.newDocumentBuilder();
			Document doc = dbBuilder.parse("ventas.xml");
			XPath xpath = XPathFactory.newInstance().newXPath();

			String expresion = "count(//venta[@id=//dpto[nombre='Carnicería']/@id])";
			String result = (String) xpath.evaluate(expresion, doc, XPathConstants.STRING);

			System.out.println("Cantidad de ventas de la carnicería: " + result);

			expresion = "//producto[@venta=//dpto[nombre='Carnicería']/@id]/precio/text()";
			result = (String) xpath.evaluate(expresion, doc, XPathConstants.STRING);

			System.out.println("Precio de productos de carnicería: " + result);

			expresion = "//producto[@id=//venta[cantidad = 3]/producto/text()]/nombre/text()";
			result = (String) xpath.evaluate(expresion, doc, XPathConstants.STRING);

			System.out.println("Nombre del producto del que se han vendido 3 unidades: " + result);

			expresion = "//dpto[@id=//producto[nombre='Naranjas']/@venta]/responsable/text()";
			result = (String) xpath.evaluate(expresion, doc, XPathConstants.STRING);

			System.out.println("Responsable del producto con nombre de Naranjas: " + result);

			expresion = "//dpto[@id=//venta[data='2013/3/10']/@id]/responsable/text()";
			result = (String) xpath.evaluate(expresion, doc, XPathConstants.STRING);

			System.out.println("Responsable de la venta realizada el 10/03/2013: " + result);

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	}


