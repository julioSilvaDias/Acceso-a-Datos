package ejer1_10;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
			Document document = dbBuilder.parse("tienda.xml");
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//1. cantidad de ventas de la carniceria
			String consulta = "count(//venta[producto = //producto[@venta='s2']/@id])\r\n";
			String resultado = (String) xPath.evaluate(consulta, document, XPathConstants.STRING);

			System.out.println("Cantidad de ventas de la carnicería: " + resultado);
			
			//2. precio productos carniceria
			consulta = "//producto[@venta='s2']/precio\r\n";
			resultado = (String) xPath.evaluate(consulta, document, XPathConstants.STRING);

			System.out.println("Precio de productos de carnicería: " + resultado);
			
			//3. nombre del producto del que se han vendido 3 unidades
			consulta = "//producto[@id=//venta[cantidad=3]/producto]/nombre";
			resultado = (String) xPath.evaluate(consulta, document, XPathConstants.STRING);

			System.out.println("Nombre del producto del que se han vendido 3 unidades: " + resultado);
			
			//4. Responsable del producto con nombre de Naranjas
			consulta = "//dpto[@id=//producto[nombre='Naranjas']/@venta]/responsable";
			resultado = (String) xPath.evaluate(consulta, document, XPathConstants.STRING);

			System.out.println("Responsable del producto con nombre de Naranjas: " + resultado);
			
			//5. Responsable de la venta realizada el 10/03/2013
			consulta = "//dpto[@id=//producto[@id=//venta[data='2013/3/10']/producto]/@venta]/responsable";
			resultado = (String) xPath.evaluate(consulta, document, XPathConstants.STRING);

			System.out.println("Responsable de la venta realizada el 10/03/2013: " + resultado);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
